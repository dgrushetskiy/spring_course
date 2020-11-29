import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.specialist.java.spring.config.JpaConfig;
import ru.specialist.java.spring.service.TagBatchService;
import ru.specialist.java.spring.service.TagService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TagServiceDemonstration {

    private TagService tagService;
    private TagBatchService tagBatchService;

    @Autowired
    public TagServiceDemonstration(TagService tagService,
                                   TagBatchService tagBatchService) {
        this.tagService = tagService;
        this.tagBatchService = tagBatchService;
    }

    @Test
    void createTag(){
//        tagBatchService.createTags("one", null, "three");
        tagService.createTags("one", null, "three");
    }
}
