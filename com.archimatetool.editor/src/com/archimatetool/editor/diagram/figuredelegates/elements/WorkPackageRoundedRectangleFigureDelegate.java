package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.geometry.Dimension;

import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.diagram.figures.RoundedRectangleFigureDelegate;

public class WorkPackageRoundedRectangleFigureDelegate extends RoundedRectangleFigureDelegate {

	public WorkPackageRoundedRectangleFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);      
		setArc(new Dimension(10, 10));
	}

}
