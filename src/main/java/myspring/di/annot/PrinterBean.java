package myspring.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public interface PrinterBean {
	public void print(String message);
}
