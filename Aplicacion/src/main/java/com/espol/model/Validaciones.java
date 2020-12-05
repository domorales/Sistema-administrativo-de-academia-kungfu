/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.model;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author dilan
 */
public class Validaciones {
    
    public static  TextFormatter restriccionesText( String rex ){
    Pattern pattern = Pattern.compile(rex);
    TextFormatter formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
        return pattern.matcher(change.getControlNewText()).matches() ? change : null;
    });
        return formatter;
    }

}
