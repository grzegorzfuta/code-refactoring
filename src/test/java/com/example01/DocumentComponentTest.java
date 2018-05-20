package com.example01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DocumentComponentTest {

    private static final String FILE_NAME = "name";
    private static final String MIME_TYPE = "type";
    private static final String FILE_CONTENT = "content";
    private static final AttachmentType ATTACHMENT_TYPE = AttachmentType.REPORT;

    private DocumentComponent documentComponent;

    @BeforeEach
    void setup() {
        documentComponent = new DocumentComponent();
    }

    private List<File> createFiles() {
        File file = new File();
        file.setName(FILE_NAME);
        file.setType(MIME_TYPE);
        file.setContent(FILE_CONTENT);
        return Arrays.asList(file);
    }

    private Event createEventWithoutFiles() {
        Event event = new Event();
        event.setInputElement(new InputElement());
        return event;
    }

    private Event createEventWithFiles() {
        Event event = createEventWithoutFiles();
        event.getInputElement().setFiles(createFiles());
        return event;
    }

    @Test
    void shouldNotCreateAttachmentForEmptyFileList() {
        Event event = createEventWithoutFiles();

        Optional<Attachment> optionalAttachment = documentComponent.createAttachment(event);

        assertFalse(optionalAttachment.isPresent());
    }

    @Test
    void shouldCreateAttachment() {
        Event event = createEventWithFiles();

        Optional<Attachment> optionalAttachment = documentComponent.createAttachment(event);

        assertTrue(optionalAttachment.isPresent());
        Attachment attachment = optionalAttachment.get();
        assertEquals(FILE_NAME, attachment.getFilename());
        assertEquals(MIME_TYPE, attachment.getMimeType());
        assertEquals(FILE_CONTENT, attachment.getFileContent());
        assertNull(attachment.getAttachmentType());
    }

    @Test
    void shouldCreateAttachmentWithType() {
        Event event = createEventWithFiles();

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
