package springone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

@Component
public class ListHttpMessageConverter extends AbstractHttpMessageConverter<List<String>> {

	@Override
	protected boolean supports(Class<?> clazz) {
		return List.class.isAssignableFrom(clazz);
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return Arrays.asList(MediaType.TEXT_HTML);
	}

	@Override
	protected List<String> readInternal(Class<? extends List<String>> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		return null;
	}

	@Override
	protected void writeInternal(List<String> t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		PrintWriter out = new PrintWriter(outputMessage.getBody());
		out.write("<html><body><ul>");
		for (String string : t) {
			out.write("<li>"+string+"</li>");
		}
		out.write("</body></html");
		out.flush();
	}

}
