package com.archimatetool.editor.diagram.figures.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.IFigure;

import com.archimatetool.editor.Logger;
import com.archimatetool.editor.diagram.figures.IFigureDelegate;

/**
 * Use this class to access figure delegate providers for any given figure (if available). Initializes the Figure
 * Delegate Providers  defined in the Figure Delegate Providers extension point and maintains a
 * list of all figure delegate providers registered this way.
 * @author Thijs Franck
 *
 */
public class FigureDelegateProviderFactory {
	
	public static final FigureDelegateProviderFactory INSTANCE = new FigureDelegateProviderFactory();
	
	static{
		INSTANCE.registerProviders();
	}

	private Map<Class<? extends IFigure>, IFigureDelegateProvider> map = new HashMap<Class<? extends IFigure>, IFigureDelegateProvider>();

	/**
	 * Registers the providers that are defined at the extension point for figure delegate providers
	 */
	@SuppressWarnings("unchecked")
	private void registerProviders() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		
	    for(IConfigurationElement configurationElement : registry.getConfigurationElementsFor(IFigureDelegateProvider.EXTENSIONPOINT_ID)) {
	        try {
	            String id = configurationElement.getAttribute("id");
	            IFigureDelegateProvider provider = (IFigureDelegateProvider)configurationElement.createExecutableExtension("class");
	            provider.setDefaultFigureDelegateType((Class<? extends IFigureDelegate>) Class.forName(configurationElement.getAttribute("defaultDelegate")));
	            if(id != null && provider != null) {
	                registerProvider(provider);
	            }
	        } 
	        catch(CoreException | ClassNotFoundException | InvalidRegistryObjectException ex) {
	            Logger.logError("Cannot register Figure Delegate Provider", ex);
	            ex.printStackTrace();
	        } 
	    }		
	}

	private void registerProvider(IFigureDelegateProvider provider) {
		 if(provider != null && provider.providerFor() != null) {
			 map.put(provider.providerFor(), provider);
	     }
	}
	
	/**
	 * @param figureClass the figure type for which the provider should provide delegates
	 * @return the figure delegate provider associated with the given figure type, or null if no such provider exists
	 */
	public IFigureDelegateProvider getProviderForClass(Class<? extends IFigure> figureClass) {
        return figureClass == null ? null : map.get(figureClass);
    }
    
	/**
	 * @param figure the figure for which the provider should provide delegates
	 * @return the figure delegate provider associated with the type of the given figure, or null if no such provider exists
	 */
    public IFigureDelegateProvider getProvider(IFigure figure) {
    	Class<? extends IFigure> figureClass = null;
        
        if(figure != null) {
            figureClass = figure.getClass();
        }

        return getProviderForClass(figureClass);
    }
    
    /**
     * @return a list of all registered providers
     */
    public List<IFigureDelegateProvider> getProviders() {
        return new ArrayList<>(map.values());
    }

}
