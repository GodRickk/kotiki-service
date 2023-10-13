import org.junit.jupiter.api.*;
import org.mockito.*;
import ru.itmo.dao.*;
import ru.itmo.entity.Cat;
import ru.itmo.entity.Owner;
import ru.itmo.enums.Color;
import ru.itmo.service.CatService;
import ru.itmo.service.OwnerService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {
    @Mock
    IOwnerDao ownerDao = new OwnerDao();
    @Mock
    ICatDao catDao = new CatDao();
    OwnerService ownerService;
    CatService catService;
    Calendar calendar = new GregorianCalendar(2000, Calendar.APRIL, 17);
    Owner owner;
    List<Cat> catList;
    MockitoSession session;

    @BeforeEach
    public void initialization() {
        session = Mockito.mockitoSession().initMocks(this).startMocking();
        catService = new CatService(catDao);
        ownerService = new OwnerService(ownerDao);
        owner = new Owner("Jora", calendar.getTime());
        catList = Stream.of(new Cat("Jija", Color.Black, "Fluffy asshole", calendar.getTime(), owner),
                            new Cat("Markus Avreliy", Color.Black, "Lazy bones", calendar.getTime(), owner)).collect(Collectors.toList());

    }

    @AfterEach
    public void finish() {
        session.finishMocking();
    }

    @Test
    void GetAllCats() {
        Mockito.when(catDao.getAll()).thenReturn(catList);
        List<Cat> cats = catService.getAll();
        Assertions.assertNotNull(catList);
    }

    @Test
    void GetAllFriends() {
        Mockito.when(catDao.getAll()).thenReturn(catList);
        Mockito.when(catDao.getAllFriends(catList.get(1).getId())).thenReturn(Stream.of(catList.get(0)).collect(Collectors.toList()));
        List<Cat> cats = catService.getAll();
        Cat cat = cats.get(1);
        List<Cat> catFriends = catService.getAllFriends(cat.getId());
        Assertions.assertEquals(catFriends.get(0), cats.get(0));
    }

    @Test
    void GetOwnerCatList() {
        Mockito.when(ownerDao.getOwnerCatList(owner.getOwnerId())).thenReturn(catList);
        List<Cat> catList1 = ownerService.getOwnerCatList(owner.getOwnerId());
        Assertions.assertEquals(catList, catList1);
    }
}
