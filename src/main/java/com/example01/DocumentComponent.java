package com.example01;

import java.util.Optional;

public class DocumentComponent {

    private static String EMPTY_STRING = "";
    private static String DEFAULT_MIME_TYPE = "application/octet-stream";

    private Document document;

    public Optional<Attachment> createAttachment(Event event) {
        return createAttachment(event, null);
    }

    public Optional<Attachment> createAttachment(Event event, AttachmentType attachmentType) {
        InputElement inputElement = event.getInputElement();

        if (!inputElement.getFiles().isEmpty()) {
            File file = inputElement.getFiles().get(0);
            Attachment attachment = new Attachment(file.getName(),
                    getMimeType(file.getType()),
                    file.getContent(),
                    attachmentType);
            return Optional.of(attachment);
        }
        return Optional.empty();
    }

    private String getMimeType(String mimeType) {
        return EMPTY_STRING.equals(mimeType) ? DEFAULT_MIME_TYPE : mimeType;
    }

}