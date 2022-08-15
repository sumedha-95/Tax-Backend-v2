package com.sha.springboottaxapplication.repository.projection;

import java.time.LocalDateTime;

public interface FileItem {
    String getName();
    String getUrl();
    LocalDateTime getUploadTime();
}
