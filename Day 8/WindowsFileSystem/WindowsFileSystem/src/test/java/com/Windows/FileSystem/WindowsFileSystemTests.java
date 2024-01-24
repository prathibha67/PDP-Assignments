package com.Windows.FileSystem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
class WindowsFileSystemTests {

	/*@Test
	void testFileShowDetails() {
		// Given
		FileSystemApplication.File file = new FileSystemApplication.File("testFile.txt");

		// When
		file.showDetails();

		// Then
		// You can use Mockito to verify that the showDetails method is called
		verify(System.out).println("File: testFile.txt");
	}
   */
	@Test
	void testDirectoryShowDetails() {
		// Given
		FileSystemApplication.Directory directory = new FileSystemApplication.Directory("testDirectory");

		// Mock components
		FileSystemApplication.FileSystemComponent mockFile = Mockito.mock(FileSystemApplication.FileSystemComponent.class);
		Mockito.when(mockFile.toString()).thenReturn("DocFile");

		// Add the mock file to the directory
		directory.addComponent(mockFile);

		// When
		directory.showDetails();

		// Then
		// Verify that the showDetails method of the mock file is called
		verify(mockFile).showDetails();
		// You can also use Mockito to verify that the println statement is called, but it's more complex due to the recursive nature of showDetails
	}

	@Test
	void testWindowsFileSystemApplication() {
		// Given
		FileSystemApplication.File document = new FileSystemApplication.File("App.txt");
		FileSystemApplication.File image = new FileSystemApplication.File("Image.jpg");

		FileSystemApplication.Directory root = new FileSystemApplication.Directory("user");
		FileSystemApplication.Directory documents = new FileSystemApplication.Directory("Docker");

		documents.addComponent(document);
		documents.addComponent(image);

		root.addComponent(documents);

		// When
		root.showDetails();

		// Then
		// You can use Mockito to verify that the showDetails methods are called for each component, but it's more complex due to the recursive nature
	}
	@Test
	void contextLoads() {
	}

}
