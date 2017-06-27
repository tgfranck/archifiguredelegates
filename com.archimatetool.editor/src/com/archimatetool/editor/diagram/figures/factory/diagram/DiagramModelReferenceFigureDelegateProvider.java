package com.archimatetool.editor.diagram.figures.factory.diagram;

import org.eclipse.draw2d.IFigure;

import com.archimatetool.editor.diagram.figures.diagram.DiagramModelReferenceFigure;
import com.archimatetool.editor.diagram.figures.factory.AbstractFigureDelegateProvider;

public class DiagramModelReferenceFigureDelegateProvider extends AbstractFigureDelegateProvider {

	@Override
	public Class<? extends IFigure> providerFor() {
		return DiagramModelReferenceFigure.class;
	}

}
