package main.java.com.example.groceryauth;

@RestController
@CrossOrigin
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepo;

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }
}
