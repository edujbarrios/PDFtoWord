import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class PDFToWord {
  public static void convertPDFToWord(String inputFilePath, String outputFileName) throws Exception {
    // Load the PDF document
    File inputFile = new File(inputFilePath);
    PDDocument document = PDDocument.load(inputFile);

    // Extract text from PDF
    PDFTextStripper pdfStripper = new PDFTextStripper();
    String text = pdfStripper.getText(document);

    // Write the extracted text to a Microsoft Word document
    File outputFile = new File(outputFileName + ".docx");
    FileOutputStream outputStream = new FileOutputStream(outputFile);
    outputStream.write(text.getBytes());
    outputStream.close();

    // Close the PDF document
    document.close();
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // ~/remember 
    System.out.print("Enter the file path of the PDF: ");
    String filePath = input.nextLine();

    System.out.print("Enter the output file name (without extension): ");
    String outputFileName = input.nextLine();

    try {
      convertPDFToWord(filePath, outputFileName);
      System.out.println("The PDF was successfully converted to a Microsoft Word document and saved as " + outputFileName + ".docx");
    } catch (Exception e) {
      System.out.println("An error occurred while converting the PDF to a Microsoft Word document");
      e.printStackTrace();
    }
  }
}
