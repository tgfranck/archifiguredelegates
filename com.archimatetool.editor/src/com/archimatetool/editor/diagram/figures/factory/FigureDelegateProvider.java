package com.archimatetool.editor.diagram.figures.factory;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EAttribute;

import com.archimatetool.editor.diagram.figuredelegates.IFigureDelegate;
import com.archimatetool.editor.diagram.figuredelegates.IFigureDelegateFilter;
import com.archimatetool.editor.diagram.figuredelegates.factory.FigureDelegateFactory;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.model.IDiagramModelArchimateObject;
import com.archimatetool.model.IDiagramModelObject;

/**
 * @author Thijs Franck
 */
public class FigureDelegateProvider implements IFigureDelegateProvider {
	
	private final Set<Class<? extends IFigureDelegate>> REGISTER = new HashSet<Class<? extends IFigureDelegate>>();
	
	private final Class<? extends IFigureDelegate> DEFAULT_DELEGATE_TYPE;
		
	private final Class<? extends IFigure> PROVIDER_FOR;
	
	private Class<? extends IFigureDelegate> currentDelegateType;
	
	private final Set<IFigureDelegateFilter> filters = new HashSet<IFigureDelegateFilter>();
	
	public FigureDelegateProvider(Class<? extends IFigure> providerFor, Class<? extends IFigureDelegate> defaultDelegateType){
		PROVIDER_FOR = providerFor;
		DEFAULT_DELEGATE_TYPE = defaultDelegateType;
	}
	
	@Override
	public IFigureDelegate createFigureDelegate(IDiagramModelObjectFigure owner) {
		IFigureDelegate result = null;
		
		IDiagramModelObject dmo =  owner.getDiagramModelObject();
		if(dmo instanceof IDiagramModelArchimateObject){
			
			IDiagramModelArchimateObject dmao = (IDiagramModelArchimateObject) dmo;
			
			if(dmao.getFigureDelegateType() != null){
				result = FigureDelegateFactory.INSTANCE.createFigureDelegate((Class<? extends IFigureDelegate>)dmao.getFigureDelegateType(), owner);
			}
			else if(getFigureDelegateType() != null){
				result = FigureDelegateFactory.INSTANCE.createFigureDelegate(getFigureDelegateType(), owner);
				dmao.setFigureDelegateType(getFigureDelegateType());
			}
			else{
				result = FigureDelegateFactory.INSTANCE.createFigureDelegate(getDefaultFigureDelegateType(), owner);
				dmao.setFigureDelegateType(getDefaultFigureDelegateType());
			}
			
			applyFilters(result);
			
		}
		return result;
	}
	
	private void applyFilters(IFigureDelegate delegate) {
		filters.forEach((filter) -> filter.apply(delegate));		
	}

	@Override
	public Class<? extends IFigureDelegate> getDefaultFigureDelegateType() {
		return DEFAULT_DELEGATE_TYPE;
	}

	@Override
	public void setFigureDelegateType(Class<? extends IFigureDelegate> type) {		
		this.currentDelegateType = type;
	}

	@Override
	public Class<? extends IFigureDelegate> getFigureDelegateType() {
		return currentDelegateType;
	}
	
	@Override
    public void registerFigureDelegateType(Class<? extends IFigureDelegate> delegateClass){
    	REGISTER.add(delegateClass);
    }
    
	@Override
    public Set<Class<? extends IFigureDelegate>> getFigureDelegateRegister(){
    	return REGISTER;
    }
	
	@Override
	public boolean shouldExposeFeature(EAttribute feature) {
		return true;
	}

	@Override
	public Class<? extends IFigure> providerFor() {
		return PROVIDER_FOR;
	}

	@Override
	public void addFilter(IFigureDelegateFilter filter) {
		filters.add(filter);
	}

	@Override
	public Set<IFigureDelegateFilter> getFilters() {
		return filters;
	}

}
