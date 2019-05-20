/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.primigenius.ade.generating;
import com.itextpdf.text.DocumentException;
import static com.itextpdf.text.pdf.BaseFont.EMBEDDED;
import static com.itextpdf.text.pdf.BaseFont.IDENTITY_H;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import static org.thymeleaf.templatemode.TemplateMode.HTML;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;
import pl.primigemius.ade.report.Address;
import pl.primigemius.ade.report.Archive;
import pl.primigemius.ade.report.PackageReportData;
import pl.primigemius.ade.report.User;
import pl.primigemius.ade.report.VerificationResult;
import pl.primigemius.ade.report.VerificationType;
import pl.primigenius.enums.FileTypeEnum;
import pl.primigenius.services.VerificationTypeService;

/**
 *
 * @author Kamil
 */
public class PackageReport {
    private static final String OUTPUT_FILE = "test.pdf";
    private static final String UTF_8 = "UTF-8";

    public static void main(String[] args) throws UnsupportedEncodingException, DocumentException, IOException  {
        PackageReportData data = exampleDataForPackageReport();
        generatePDF(data);
        
    }
    
    public static void generateReport(PackageReportData data, FileTypeEnum type) throws DocumentException, IOException{
        switch(type){
            case XML:
                break;
            case PDF:
                generatePDF(data);
                break;
        }
    }
    private static PackageReportData exampleDataForPackageReport() {
        Archive archive1 = new Archive();
        archive1.setName("Pañstwowe archiwum w Warszawie");
        Address address1 = new Address();
        address1.setApartmentNumber("21");
        address1.setBuildingNumber("23");
        address1.setCity("Warszawa");
        address1.setStreet("Przyk³adowa");
        address1.setZipCode("84-234");
        archive1.setAddress(address1);
        
        Archive archive2 = new Archive();
        archive2.setName("Urz¹d Miasta Jaworzno");
        Address address2 = new Address();
        address2.setApartmentNumber("21");
        address2.setBuildingNumber("23");
        address2.setCity("Jaworzno");
        address2.setStreet("Przyk³adowa");
        address2.setZipCode("84-234");
        archive2.setAddress(address2);
        
        User user = new User("Kamil","Testowy");
        
        LocalDateTime time = LocalDateTime.now();
        
        BigDecimal packageSize = new BigDecimal(2);
        
        String caseId = "2131/21321";
        String packageIdentifier = "154";
        String packageFileName = "Paczka archiwalna nr.20";
        
        String comment = "Paczka jest za ciê¿ka. Paczka jest za ciê¿ka. Paczka jest za ciê¿ka. Paczka jest za ciê¿ka.";
        
        List<VerificationResult> verificationResultList = new ArrayList();
        
        for(VerificationType type: VerificationType.values()){
            VerificationResult result = new VerificationResult();
            result.setTypeString(VerificationTypeService.getValue(type));
            result.setSuccess(true);
            result.setSuccessMessage("Paczka w spe³nia kryteria. Paczka w spe³nia kryteria. ");
            List<String> errors = new ArrayList();
            errors.add("Error przy sk³adaniu wniosku");
            errors.add("Error przy pobieraniu wniosku");
            result.setErrors(errors);
            
            verificationResultList.add(result);
        }
        
        
        PackageReportData data = new PackageReportData(archive1, archive2, user, time, time, packageSize,caseId,time, packageIdentifier, packageFileName, verificationResultList,user,comment);
        return data;
    }

    private static String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
    }
    
    private static void generatePDF(PackageReportData raport) throws UnsupportedEncodingException, DocumentException, IOException{
        
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(HTML);
        templateResolver.setCharacterEncoding(UTF_8);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("data", raport);

        String renderedHtmlContent = templateEngine.process("template", context);
        String xHtml = convertToXhtml(renderedHtmlContent);
        ITextRenderer renderer = new ITextRenderer();
        renderer.getFontResolver().addFont("Roboto-Regular.ttf", IDENTITY_H, EMBEDDED);
        renderer.getFontResolver().addFont("Roboto-Medium.ttf", IDENTITY_H, EMBEDDED);
        String baseUrl = FileSystems
                                .getDefault()
                                .getPath("src", "main", "resources")
                                .toUri()
                                .toURL()
                                .toString();
        renderer.setDocumentFromString(xHtml, baseUrl);
        renderer.layout();
        OutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
        renderer.createPDF(outputStream);
        outputStream.close();
    }
    
    private static void generateXML(PackageReportData raport){
        
    }
}
