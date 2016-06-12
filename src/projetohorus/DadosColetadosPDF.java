/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetohorus;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.PageSize;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import org.apache.commons.net.util.SubnetUtils;

/**
 *
 * @author Vectro26
 */
public class DadosColetadosPDF extends PingIP {

    void GerarPDF() throws IOException, DocumentException {
        Document doc = null;
        OutputStream os = null;

        try {

            InetAddress localHost = Inet4Address.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
            short x = networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
            String n = localHost.getHostAddress() + "/" + x;
            SubnetUtils utils = new SubnetUtils(n);

            doc = new Document(PageSize.A4, 72, 72, 72, 72);
            os = new FileOutputStream("tesfinal11.pdf");
            PdfWriter.getInstance(doc, os);
            doc.open();

            PdfPTable table = new PdfPTable(new float[]{0.50f, 0.70f, 0.90f});

            table = new PdfPTable(3);

            Paragraph p = new Paragraph("PROJETO HORUS");
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(30);
            doc.add(p);
            p = new Paragraph("Informações da Network");
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(30);

            doc.add(p);
            Paragraph paragraph = new Paragraph("" + utils.getInfo());
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setSpacingAfter(30);
            doc.add(paragraph);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell header = new PdfPCell(new Paragraph("Diagnostico do Scanner da Rede"));
            header.setColspan(3);
            table.addCell(header);
            table.addCell("IP");
            table.addCell("HostName");
            table.addCell("Portas Abertas");
            for (int i = 0; i < IP.size(); i++) {

                table.addCell(IP.get(i));
                table.addCell(NameHost.get(i));
                table.addCell("" + PortasA.get(i).toString());
            }
            doc.add(table);

        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }

        }

    }
}
