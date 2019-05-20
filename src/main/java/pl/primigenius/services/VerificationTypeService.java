package pl.primigenius.services;


import pl.primigemius.ade.report.VerificationType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class VerificationTypeService {
    public static String getValue(VerificationType type){
        switch(type){
            case SIGNATURE:
                return "Pieczêæ elektroniczna";
            case HASH:
                return "Suma kontrolna";
            case JRWA:
                return "JRWA";
            case HANDOVER_REPORT: 
                return "Porównanie ze spisem zd-odb";
            case XSD_SCHEMA:
                return "Porównanie ze struktur¹ i metadanymi";
            default:
                return "";
        }
    }
}
