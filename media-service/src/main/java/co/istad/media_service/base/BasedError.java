package co.istad.media_service.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BasedError<T> {
    private String code;
    private T description;
}
