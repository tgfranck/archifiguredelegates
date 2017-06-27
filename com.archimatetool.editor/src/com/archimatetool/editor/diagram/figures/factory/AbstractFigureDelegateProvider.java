package com.archimatetool.editor.diagram.figures.factory;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;

import com.archimatetool.editor.diagram.figuredelegates.factory.FigureDelegateFactory;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.diagram.figures.IFigureDelegate;
import com.archimatetool.model.IDiagramModelArchimateObject;
import com.archimatetool.model.IDiagramModelObject;

/**
 * @author Thijs Franck
 */
public abstract class AbstractFigureDelegateProvider implements IFigureDelegateProvider {
	
	private final Set<Class<? extends IFigureDelegate>> REGISTER = new HashSet<Class<? extends IFigureDelegate>>();
	
	private Class<? extends IFigureDelegate> defaultDelegateType;
		
	private Class<? extends IFigureDelegate> currentDelegateType;

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
			
		}
		return result;
	}
	
	@Override
    public void setDefaultFigureDelegateType(Class<? extends IFigureDelegate> delegateClass){
    	defaultDelegateType = delegateClass;
    	if(getFigureDelegateType() == null){
    		setFigureDelegateType(delegateClass);
    	}
    }
	
	@Override
	public Class<? extends IFigureDelegate> getDefaultFigureDelegateType() {
		return defaultDelegateType;
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

}
