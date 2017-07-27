/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import com.archimatetool.editor.diagram.figuredelegates.IFigureDelegate;
import com.archimatetool.editor.diagram.figures.AbstractDiagramModelObjectFigure;
import com.archimatetool.editor.diagram.figures.factory.FigureDelegateProviderFactory;
import com.archimatetool.editor.diagram.figures.factory.IFigureDelegateProvider;
import com.archimatetool.editor.diagram.util.DiagramUtils;
import com.archimatetool.editor.ui.factory.IArchimateElementUIProvider;
import com.archimatetool.editor.ui.factory.IGraphicalObjectUIProvider;
import com.archimatetool.editor.ui.factory.ObjectUIFactory;
import com.archimatetool.model.IArchimateElement;
import com.archimatetool.model.IArchimateFactory;
import com.archimatetool.model.IDiagramModelArchimateObject;
import com.archimatetool.model.ITextPosition;


/**
 * Factory class to create preview images of Figures
 * If the Figure has an alternate figures it will return that
 * 
 * @author Phillip Beauvoir
 */
public class FigureImagePreviewFactory {
    
    static ImageRegistry imageRegistry = new ImageRegistry();
    
    /**
     * @param eClass
     * @return A set of preview images of the alternate graphical Figures registered for the eClass.
     *         If there is no alternate graphical Figure, an empty set is returned
     */
    
    public static Map<Image, Class<? extends IFigureDelegate>> getAlternativeFigurePreviewImagesForClass(EClass eClass){
    	Map<Image, Class<? extends IFigureDelegate>> result = null;
    	
    	IGraphicalObjectUIProvider provider = (IGraphicalObjectUIProvider)ObjectUIFactory.INSTANCE.getProviderForClass(eClass);
        
        if(provider instanceof IArchimateElementUIProvider && ((IArchimateElementUIProvider)provider).hasAlternateFigure()) {
            result = getPreviewImages((IArchimateElementUIProvider)provider);
        }
        
        return result;
    }
    
    private static Map<Image, Class<? extends IFigureDelegate>> getPreviewImages(IArchimateElementUIProvider uiProvider){
    	
    	Map<Image, Class<? extends IFigureDelegate>> result = new LinkedHashMap<Image, Class<? extends IFigureDelegate>>();
    	
    	EClass eClass = uiProvider.providerFor();
    	
    	IDiagramModelArchimateObject dmo = IArchimateFactory.eINSTANCE.createDiagramModelArchimateObject();
    	
        dmo.setArchimateElement((IArchimateElement)IArchimateFactory.eINSTANCE.create(eClass));
        dmo.setName(uiProvider.getDefaultName());
        dmo.setTextPosition(ITextPosition.TEXT_POSITION_TOP);
        
        ColorFactory.setDefaultColors(dmo);

        uiProvider.setInstance(dmo);

        GraphicalEditPart editPart = (GraphicalEditPart)uiProvider.createEditPart();
        editPart.setModel(dmo);
        
        AbstractDiagramModelObjectFigure figure = (AbstractDiagramModelObjectFigure)editPart.getFigure();
        figure.setBounds(new Rectangle(0,0,100,100));
        
        IFigureDelegateProvider delegateProvider = FigureDelegateProviderFactory.INSTANCE.getProvider(figure);
        
        for(Class<? extends IFigureDelegate> alternative : delegateProvider.getFigureDelegateRegister()){
        	dmo.setFigureDelegateType(alternative);
        	result.put(DiagramUtils.createImage(figure, 1, 0), alternative);
        }
		
        return result;
    	
    }
}
