package com.example01;

public class Attachment {

    private final String filename;
    private final String mimeType;
    private final String fileContent;
    private final AttachmentType attachmentType;

    public Attachment(String filename, String mimeType, String fileContent, AttachmentType attachmentType) {
        this.filename = filename;
        this.mimeType = mimeType;
        this.fileContent = fileContent;
        this.attachmentType = attachmentType;
    }

    public String getFilename() {
        return filename;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getFileContent() {
        return fileContent;
    }

    public AttachmentType getAttachmentType() {
        return attachmentType;
    }

}
