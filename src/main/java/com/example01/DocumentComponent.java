package com.example01;

public class DocumentComponent {

    private Document document;

    public Attachment createAttachment(Event event) {
        InputElement inputElement = event.getInputElement();

        if (!inputElement.getFiles().isEmpty()) {
            File file = inputElement.getFiles().get(0);
            if (file.getName() != null) {
                Attachment attachment = new Attachment();
                attachment.setFilename(file.getName());
                attachment.setMimeType(file.getType());
                attachment.setFileContent(file.getContent());

                return attachment;
            }
        }
        return null;
    }

    public Attachment createAttachmentWithType(Event event, AttachmentType attachmentType) {
        InputElement inputElement = event.getInputElement();

        if (!inputElement.getFiles().isEmpty()) {
            File file = inputElement.getFiles().get(0);
            if (file.getName() != null) {
                Attachment attachment = new Attachment();
                attachment.setFilename(file.getName());
                attachment.setMimeType(file.getType());
                attachment.setFileContent(file.getContent());
                attachment.setAttachmentType(attachmentType);
                return attachment;
            }
        }
        return null;
    }

}