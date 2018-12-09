package hibernet.example.demo.db.entity;

public class EsDocumentConversionParserExceptions extends Exception {

	public EsDocumentConversionParserExceptions(String field, String value) {

		super("Unable to convert String to List<String> for " + field + " " + value + ".");
	}

}
