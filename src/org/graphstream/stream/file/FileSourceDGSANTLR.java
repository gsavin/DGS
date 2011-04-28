package org.graphstream.stream.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.graphstream.stream.SinkAdapter;
import org.graphstream.stream.SourceBase;

public class FileSourceDGSANTLR extends SourceBase implements FileSource {

	DGSLexer lexer;
	DGSParser parser;
	ANTLRStringStream stream;

	public void readAll(String fileName) throws IOException {
		// TODO Auto-generated method stub

	}

	public void readAll(URL url) throws IOException {
		// TODO Auto-generated method stub

	}

	public void readAll(InputStream stream) throws IOException {
		// TODO Auto-generated method stub

	}

	public void readAll(Reader reader) throws IOException {
		// TODO Auto-generated method stub

	}

	public void begin(String fileName) throws IOException {
		// TODO Auto-generated method stub

	}

	public void begin(URL url) throws IOException {
		// TODO Auto-generated method stub

	}

	public void begin(InputStream stream) throws IOException {
		// TODO Auto-generated method stub

	}

	public void begin(Reader reader) throws IOException {
		stream = new ANTLRReaderStream(reader);
		lexer = new DGSLexer(stream);
		parser = new DGSParser(new CommonTokenStream(lexer));
		parser.setSource(sourceId, this);

		try {
			parser.header();
		} catch (RecognitionException e) {
			throw new IOException(e);
		}
	}

	public boolean nextEvents() throws IOException {
		try {
			return parser.directive();
		} catch (RecognitionException e) {
			throw new IOException(e);
		}
	}

	public boolean nextStep() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	public void end() throws IOException {
		// TODO Auto-generated method stub

	}

	static class FakeSink extends SinkAdapter {
		public void nodeAdded(String sourceId, long timeId, String nodeId) {
			System.out.printf("node \"%s\" added\n", nodeId);
		}
	}

	public static void main(String... args) {
		long m1, m2, d;

		FileSourceDGSANTLR dgs = new FileSourceDGSANTLR();
		// dgs.addSink(new FakeSink());

		FileSourceDGS dgs2 = new FileSourceDGS();

		try {
			int size = 10;
			d = 0;

			for (int i = 0; i < size; i++) {
				dgs2.begin(new FileReader("graph.dgs"));
				m1 = System.currentTimeMillis();
				while (dgs2.nextEvents())
					;
				m2 = System.currentTimeMillis();
				d += m2 - m1;
			}
			System.out.printf("basic done in %dms\n", d / size);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			int size = 10;
			d = 0;

			for (int i = 0; i < size; i++) {
				dgs.begin(new FileReader("graph.dgs"));
				m1 = System.currentTimeMillis();
				while (dgs.nextEvents())
					;
				m2 = System.currentTimeMillis();
				d += m2 - m1;
			}
			System.out.printf("antlr done in %dms\n", d / size);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
