package com.example01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DocumentComponentTest {

    private static final String FILE_NAME = "name";
    private static final String MIME_TYPE = "type";
    private static final String NO_MIME_TYPE = "";
    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    private static final String FILE_CONTENT = "content";
    private static final AttachmentType ATTACHMENT_TYPE = AttachmentType.REPORT;

    private DocumentComponent documentComponent;

    @BeforeEach
    void setup() {
        documentComponent = new DocumentComponent();
    }

    private List<File> createFileWithType(String type) {
        File file = new File();
        file.setName(FILE_NAME);
        file.setType(type);
        file.setContent(FILE_CONTENT);
        return Arrays.asList(file);
    }

    private Event createEventWithoutFile() {
        Event event = new Event();
        event.setInputElement(new InputElement());
        return event;
    }

    private Event createEventWithFile(String type) {
        Event event = createEventWithoutFile();
        event.getInputElement().setFiles(createFileWithType(type));
        return event;
    }

    @Test
    void shouldNotCreateAttachmentForEmptyFileList() {
        Event event = createEventWithoutFile();

        Optional<Attachment> optionalAttachment = documentComponent.createAttachment(event);

        assertFalse(optionalAttachment.isPresent());
    }

    static Stream<Arguments> mimeTypeArgumentProvider() {
        return Stream.of(
                Arguments.of(MIME_TYPE, MIME_TYPE),
                Arguments.of(NO_MIME_TYPE, DEFAULT_MIME_TYPE)
        );
    }

    @ParameterizedTest
    @MethodSource("mimeTypeArgumentProvider")
    void shouldCreateAttachment(String fileType, String attachmentType) {
        Event event = createEventWithFile(fileType);

        Optional<Attachment> optionalAttachment = documentComponent.createAttachment(event);

        assertTrue(optionalAttachment.isPresent());
        Attachment attachment = optionalAttachment.get();
        assertEquals(FILE_NAME, attachment.getFilename());
        assertEquals(attachmentType, attachment.getMimeType());
        assertEquals(FILE_CONTENT, attachment.getFileContent());
        assertNull(attachment.getAttachmentType());
    }

    @Test
    void shouldCreateAttachmentWithType() {
        Event event = createEventWithFile(MIME_TYPE);

        Optional<Attachment> optionalAttachment = documentComponent.createAttachment(event, ATTACHMENT_TYPE);

        assertTrue(optionalAttachment.isPresent());
        Attachment attachment = optionalAttachment.get();

        assertNotNull(attachment);
        assertEquals(FILE_NAME, attachment.getFilename());
        assertEquals(MIME_TYPE, attachment.getMimeType());
        assertEquals(FILE_CONTENT, attachment.getFileContent());
        assertEquals(ATTACHMENT_TYPE, attachment.getAttachmentType());
    }

}
