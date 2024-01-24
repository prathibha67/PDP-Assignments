package com.Windows.FileSystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WindowsFileSystem {

	public static void main(String[] args) {

		FileSystemApplication.File document = new FileSystemApplication.File("App.txt");
		FileSystemApplication.File image = new FileSystemApplication.File("Image.jpg");


		FileSystemApplication.Directory root = new FileSystemApplication.Directory("user");
		FileSystemApplication.Directory documents = new FileSystemApplication.Directory("Docker");


		documents.addComponent(document);
		documents.addComponent(image);


		root.addComponent(documents);


		root.showDetails();
	}
}
