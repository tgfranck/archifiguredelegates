package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;

import com.archimatetool.editor.diagram.figuredelegates.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;

public abstract class AbstractPolygonalFigureDelegate extends AbstractFigureDelegate {

	protected AbstractPolygonalFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}

	@Override
	public abstract void drawFigure(Graphics graphics);

	@Override
	public abstract void drawShape(Graphics graphics);
	
	/**
	 * @return A list of points that define this shape
	 */
	public abstract PointList getPoints();

}
