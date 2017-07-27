/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.elements;

import org.eclipse.draw2d.ConnectionAnchor;

import com.archimatetool.editor.diagram.editparts.RoundedRectangleAnchor;
import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;
import com.archimatetool.model.IDiagramModelArchimateObject;

/**
 * Process Figure
 * 
 * @author Phillip Beauvoir
 */
public class ProcessFigure extends AbstractTextControlContainerFigure {

    public ProcessFigure() {
        super(TEXT_FLOW_CONTROL);
    }

    @Override
    public ConnectionAnchor getDefaultConnectionAnchor() {
        return new RoundedRectangleAnchor(this);
    }
    
    @Override
    public IDiagramModelArchimateObject getDiagramModelObject() {
        return (IDiagramModelArchimateObject)super.getDiagramModelObject();
    }
}
