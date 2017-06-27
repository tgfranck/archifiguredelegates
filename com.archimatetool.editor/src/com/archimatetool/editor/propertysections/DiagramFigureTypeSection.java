/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.propertysections;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

import com.archimatetool.editor.diagram.figures.IFigureDelegate;
import com.archimatetool.editor.model.commands.EObjectFeatureCommand;
import com.archimatetool.editor.ui.FigureImagePreviewFactory;
import com.archimatetool.editor.ui.factory.IArchimateElementUIProvider;
import com.archimatetool.editor.ui.factory.ObjectUIFactory;
import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.IDiagramModelArchimateObject;



/**
 * Section to change the type of figure for a diagram object
 * 
 * @author Phillip Beauvoir
 */
public class DiagramFigureTypeSection extends AbstractArchimatePropertySection {

    private static final String HELP_ID = "com.archimatetool.help.diagramFigureTypeSection"; //$NON-NLS-1$
    
    /**
     * Filter to show or reject this section depending on input value
     */
    public static class Filter extends ObjectFilter {
        @Override
        protected boolean isRequiredType(Object object) {
            if(object instanceof IDiagramModelArchimateObject) {
                IArchimateElementUIProvider provider = (IArchimateElementUIProvider)ObjectUIFactory.INSTANCE.getProvider((IDiagramModelArchimateObject)object);
                return provider.hasAlternateFigure();
            }
            return false;
        }

        @Override
        protected Class<?> getAdaptableType() {
            return IDiagramModelArchimateObject.class;
        }
    }
    
    /*
     * Adapter to listen to changes made elsewhere (including Undo/Redo commands)
     */
    private Adapter eAdapter = new AdapterImpl() {
        @Override
        public void notifyChanged(Notification msg) {
            Object feature = msg.getFeature();
            // Model event (Undo/Redo and here!)
	        if(feature == IArchimatePackage.Literals.DIAGRAM_MODEL_ARCHIMATE_OBJECT__FIGURE_DELEGATE_TYPE) {
	        	refreshControls();
	        }	        
        }
    };
    
    private IDiagramModelArchimateObject fDiagramObject;
    
    private Set<ImageFigure> figures = new LinkedHashSet<ImageFigure>();
    
    private Composite parent;

    @Override
    protected void createControls(Composite parent) {
    	
    	this.parent = parent;
    	
        // Help ID
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, HELP_ID);
        
    }
    
    protected void refreshControls() {
    	
    	for(ImageFigure figure: figures){
    		figure.dispose();
    	}
    	
    	figures.clear();
        
        Map<Image, Class<? extends IFigureDelegate>> images = FigureImagePreviewFactory.getAlternativeFigurePreviewImagesForClass(fDiagramObject.getArchimateElement().eClass());
        
        for(Entry<Image, Class<? extends IFigureDelegate>> e : images.entrySet()) {
        	ImageFigure figure = new ImageFigure(parent, e.getValue());        	
        	figure.setImage(e.getKey());
        	figure.setSelected(e.getValue() == fDiagramObject.getFigureDelegateType());
        	figures.add(figure);
        }
        
        parent.layout();
        
    }

    @Override
    protected Adapter getECoreAdapter() {
        return eAdapter;
    }

    @Override
    protected EObject getEObject() {
        return fDiagramObject;
    }

    @Override
    protected void setElement(Object element) {
        fDiagramObject = (IDiagramModelArchimateObject)new Filter().adaptObject(element);
        if(fDiagramObject == null) {
            System.err.println(getClass() + " failed to get element for " + element); //$NON-NLS-1$
        }
        
        refreshControls();
    }
    
    @Override
    public boolean shouldUseExtraSpace() {
        // Need this so different image heights draw correctly
        return true;
    }
    
    private class ImageFigure extends Composite {
    	
        boolean selected;
        Label label;

        public ImageFigure(Composite parent, Class<? extends IFigureDelegate> delegateClass) {
            super(parent, SWT.NULL);
            setBackgroundMode(SWT.INHERIT_DEFAULT);
            GridLayout gridLayout = new GridLayout();
            gridLayout.marginWidth = 3;
            gridLayout.marginHeight = 3;
            setLayout(gridLayout);
            
            addPaintListener(new PaintListener() {
                @Override
                public void paintControl(PaintEvent e) {
                    if(selected) {
                        GC graphics = e.gc;
                        graphics.setForeground(ColorConstants.blue);
                        graphics.setLineWidth(2);
                        Rectangle bounds = getBounds();
                        graphics.drawRectangle(1, 1, bounds.width - 2, bounds.height - 2);
                    }
                }
            });
            
            label = new Label(this, SWT.NULL);
            getWidgetFactory().adapt(this);
            
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseDown(MouseEvent e) {
                    if(!selected && isAlive()) {
                    	fDiagramObject.setFigureDelegateType(delegateClass);  
                        Class<?> newDelegateClass = fDiagramObject.getFigureDelegateType();
                        getCommandStack().execute(new EObjectFeatureCommand(Messages.DiagramFigureTypeSection_0, getEObject(),
                                IArchimatePackage.Literals.DIAGRAM_MODEL_ARCHIMATE_OBJECT__FIGURE_DELEGATE_TYPE, newDelegateClass));
                    }
                }
            });
        }
        
        void setImage(Image image) {
            label.setImage(image);
        }
        
        void setSelected(boolean set) {
            selected = set;
            redraw();
        }
    }

}
