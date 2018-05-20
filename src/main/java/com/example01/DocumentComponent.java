package com.example01;

import java.util.Optional;

public class DocumentComponent {

    private Document document;

    public Optional<Attachment> createAttachment(Event event) {
        return createAttachment(event, null);
    }

    public Optional<Attachment> createAttachment(Event event, AttachmentType attachmentType) {
        InputElement inputElement = event.getInputElement();

        if (!inputElement.getFiles().isEmpty()) {
            File file = inputElement.getFiles().get(0);
            Attachment attachment = new Attachment();
            attachment.setFilename(file.getName());
            attachment.setMimeType(file.getType());
            attachment.setFileContent(file.getContent());
            attachment.setAttachmentType(attachmentType);
            return Optional.of(attachment);
        }
        return Optional.empty();
    }

}