/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.ui.factory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;




/**
 * Abstract Object UI Provider
 * 
 * @author Phillip Beauvoir
 */
public abstract class AbstractObjectUIProvider implements IObjectUIProvider {
    
    /**
     * The instance of object for this provider.
     * If this is null then we are concerned with the class.
     */
    protected EObject instance;
    
    protected AbstractObjectUIProvider() {
    }
    
    protected AbstractObjectUIProvider(EObject instance) {
        this.instance = instance;
    }
    
    public void setInstance(EObject instance) {
        this.instance = instance;
    }
    
    @Override
    public String getDefaultName() {
        return ""; //$NON-NLS-1$
    }
    
    @Override
    public EditPart createEditPart() {
        return null;
    }
    
    @Override
    public Image getImage() {
        return null;
    }
    
    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }
    
    @Override
    public boolean shouldExposeFeature(EAttribute feature) {
        return true;
    }
}
