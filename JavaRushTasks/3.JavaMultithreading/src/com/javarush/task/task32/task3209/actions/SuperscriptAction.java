package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by 07ers on 5/1/2017.
 */
public class SuperscriptAction extends StyledEditorKit.StyledTextAction {
    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
