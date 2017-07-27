/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import com.archimatetool.editor.ui.IArchiImages;



/**
 * Editor Input for a Diagram Editor
 * 
 * @author Phillip Beauvoir
 */
public class NullDiagramEditorInput 
implements IEditorInput {
    
    private String fFileName;
    private String fViewName;

    public NullDiagramEditorInput(String fileName, String viewName) {
        fFileName = fileName;
        fViewName = viewName;
    }
    
    public String getFileName() {
        return fFileName;
    }
    
    public String getViewName() {
        return fViewName;
    }
    
    public boolean exists() {
        return false;
    }

    public ImageDescriptor getImageDescriptor() {
        return IArchiImages.ImageFactory.getImageDescriptor(IArchiImages.ICON_DIAGRAM);
    }

    public String getName() {
        return getViewName() == null ? Messages.NullDiagramEditorInput_0 : Messages.NullDiagramEditorInput_1 + " - " + getViewName(); //$NON-NLS-1$
    }

    public String getToolTipText() {
        return getName();
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        return false;
    }

    public IPersistableElement getPersistable() {
        return null;
    }

}
