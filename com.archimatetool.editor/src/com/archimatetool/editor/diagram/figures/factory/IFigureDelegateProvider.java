package com.archimatetool.editor.diagram.figures.factory;

import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EAttribute;

import com.archimatetool.editor.diagram.figuredelegates.IFigureDelegate;
import com.archimatetool.editor.diagram.figuredelegates.IFigureDelegateFilter;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;

/**
 * @author Thijs Franck
 */
public interface IFigureDelegateProvider {
	
	String EXTENSIONPOINT_ID = "com.archimatetool.editor.figureDelegateProvider"; //$NON-NLS-1$
    
    /**
     * @return The EClass for which this is an Figure Delegate Provider
     */
    Class<? extends IFigure> providerFor();
    
    /**
     * @return The Figure Delegate for which this is a Provider
     */
    IFigureDelegate createFigureDelegate(IDiagramModelObjectFigure owner);
    
    /**
     * @return The default Figure Delegate for this Provider
     */
    Class<? extends IFigureDelegate> getDefaultFigureDelegateType();
    
    /**
     * Sets the type of delegate for this provider
     */
    void setFigureDelegateType(Class<? extends IFigureDelegate> type);
    
    /**
     * @return The type of Figure Delegate created by this provider
     */
    Class<? extends IFigureDelegate> getFigureDelegateType();
    
    /**
     * Register a figure delegate type as a suggested alternative for this provider
     */
    void registerFigureDelegateType(Class<? extends IFigureDelegate> delegateClass);
    
    /**
     * @return A set of suggested alternative delegate types for this provider
     */
    Set<Class<? extends IFigureDelegate>> getFigureDelegateRegister();
    
    /**
     * Register a figure delegate filter with the factory. The filter will be applied to every delegate that is provided.
     * @param filter the filter that should be applied
     */
    void addFilter(IFigureDelegateFilter filter);
    
    Set<IFigureDelegateFilter> getFilters();

    /**
     * @param feature The feature in question
     * @return True if this object should expose a feature in the UI
     */
    boolean shouldExposeFeature(EAttribute feature);
}
