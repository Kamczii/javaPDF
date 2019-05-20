package pl.primigemius.ade.report;

/**
 *
 * @author bartoszk
 */
public enum VerificationType {

    //pieczęć elektroniczna/ podpis elektroniczny.
    SIGNATURE,

    //skrót (suma kontrolna)
    HASH,

    //JRWA
    JRWA,

    //spis zdawczo – odbiorczy
    HANDOVER_REPORT,
    
    //schemat metadanych/ i struktura paczki. 
    XSD_SCHEMA

    
}
