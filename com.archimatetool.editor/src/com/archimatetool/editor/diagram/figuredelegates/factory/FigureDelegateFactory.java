package com.archimatetool.editor.diagram.figuredelegates.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;

import com.archimatetool.editor.Logger;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.diagram.figures.IFigureDelegate;
import com.archimatetool.editor.diagram.figures.factory.FigureDelegateProviderFactory;
import com.archimatetool.editor.diagram.figures.factory.IFigureDelegateProvider;

/**
 * Use this class to create new Figure Delegates. Initializes the Figure
 * Delegates defined in the Figure Delegates extension point and maintains a
 * list of all figure delegates registered this way.
 * 
 * @author Thijs Franck
 *
 */
public class FigureDelegateFactory {

	/**
	 * The instance of the Figure Delegate Factory
	 */
	public static final FigureDelegateFactory INSTANCE = new FigureDelegateFactory();

	static {
		INSTANCE.registerDelegates();
	}

	private List<Class<? extends IFigureDelegate>> index = new ArrayList<Class<? extends IFigureDelegate>>();

	/**
	 * Register the Figure Delegates defined in the Figure Delegates extension point. If a provid
	 */
	@SuppressWarnings("unchecked")
	private void registerDelegates() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();

		for (IConfigurationElement configurationElement : registry
				.getConfigurationElementsFor(IFigureDelegate.EXTENSIONPOINT_ID)) {
			try {
				String id = configurationElement.getAttribute("id");

				Class<? extends IFigureDelegate> delegateClass = (Class<? extends IFigureDelegate>) Class
						.forName(configurationElement.getAttribute("class"));
				IFigureDelegateProvider provider = findProviderInstance((Class<? extends IFigureDelegateProvider>) Class
						.forName(configurationElement.getAttribute("provider")));
				if (id != null && delegateClass != null && provider != null) {
					registerDelegate(delegateClass, provider);
				}
			} catch (ClassNotFoundException | InvalidRegistryObjectException ex) {
				Logger.logError("Cannot register Figure Delegate", ex);
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @param delegateClass the type of delegate that should be created
	 * @param owner the figure that should own the delegate
	 * @return a new figure delegate of the given type and for the given figure
	 */
	public IFigureDelegate createFigureDelegate(Class<? extends IFigureDelegate> delegateClass,
			IDiagramModelObjectFigure owner) {
		IFigureDelegate result = null;
		try {
			result = delegateClass.getConstructor(IDiagramModelObjectFigure.class).newInstance(owner);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			Logger.logError("Cannot create Figure Delegate");
			e.printStackTrace();
		}
		return result;
	}

	private IFigureDelegateProvider findProviderInstance(Class<? extends IFigureDelegateProvider> providerClass) {
		List<IFigureDelegateProvider> providers = FigureDelegateProviderFactory.INSTANCE.getProviders();
		return providers.stream().filter((e) -> providerClass.isInstance(e)).findFirst().orElse(null);
	}

	private void registerDelegate(Class<? extends IFigureDelegate> delegateClass, IFigureDelegateProvider provider) {
		index.add(delegateClass);
		if (provider != null) {
			provider.registerFigureDelegateType(delegateClass);
			;
		}
	}

	/**
	 * @return a list of all the registered figure delegates
	 */
	public List<Class<? extends IFigureDelegate>> getFigureDelegateTypes() {
		return new ArrayList<>(index);
	}

}
