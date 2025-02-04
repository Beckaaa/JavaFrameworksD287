package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository= inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        //adding objects to inhousePartRepository
        if (inhousePartRepository.count() == 0) {
            // creating object from Part class
            InhousePart gripTape = new InhousePart();
            // setting values
            gripTape.setName("Grip Tape");
            gripTape.setInv(50);
            gripTape.setPrice(10.00);
            gripTape.setMinInv(1);
            gripTape.setMaxInv(100);
            // adding object to parts repository
            inhousePartRepository.save(gripTape);

            // creating object from Part class
            InhousePart trucks = new InhousePart();
            // setting values
            trucks.setName("Trucks");
            trucks.setInv(100);
            trucks.setPrice(15.00);
            trucks.setMinInv(2);
            trucks.setMaxInv(200);
            // adding object to parts repository
            inhousePartRepository.save(trucks);

            // creating object from Part class
            InhousePart wheels = new InhousePart();
            // setting values
            wheels.setName("Wheels");
            wheels.setInv(200);
            wheels.setPrice(5.00);
            wheels.setMinInv(4);
            wheels.setMaxInv(400);
            // adding object to parts repository
            inhousePartRepository.save(wheels);


            // creating object from Part class
            InhousePart popsicleDeck = new InhousePart();
            // setting values
            popsicleDeck.setName("Popsicle Deck");
            popsicleDeck.setInv(25);
            popsicleDeck.setPrice(20.00);
            popsicleDeck.setMinInv(1);
            popsicleDeck.setMaxInv(50);
            // adding object to parts repository
            inhousePartRepository.save(popsicleDeck);

            // creating object from Part class
            InhousePart freestyleDeck = new InhousePart();
            // setting values
            freestyleDeck.setName("Freestyle Deck");
            freestyleDeck.setInv(20);
            freestyleDeck.setPrice(25.00);
            freestyleDeck.setMinInv(1);
            freestyleDeck.setMaxInv(40);
            // adding object to parts repository
            inhousePartRepository.save(freestyleDeck);
        }

        // adding objects to outsourcedPartRepository
        if (outsourcedPartRepository.count() == 0) {
            // creating object from Part class
            OutsourcedPart bearings = new OutsourcedPart();
            // setting values
            bearings.setName("Bearings");
            bearings.setInv(200);
            bearings.setPrice(8.00);
            bearings.setCompanyName("Skate Parts Source");
            bearings.setMinInv(4);
            bearings.setMaxInv(400);
            // adding object to parts repository
            outsourcedPartRepository.save(bearings);

            // creating object from Part class
            OutsourcedPart ldpDeck = new OutsourcedPart();
            // setting values
            ldpDeck.setName("Long Distance Pumping Deck");
            ldpDeck.setInv(10);
            ldpDeck.setPrice(25.00);
            ldpDeck.setCompanyName("Skate Parts Source");
            ldpDeck.setMinInv(1);
            ldpDeck.setMaxInv(20);
            // adding object to parts repository
            outsourcedPartRepository.save(ldpDeck);

            // creating object from Part class
            OutsourcedPart pennyDeck = new OutsourcedPart();
            // setting values
            pennyDeck.setName("Penny Deck");
            pennyDeck.setInv(15);
            pennyDeck.setPrice(15.00);
            pennyDeck.setCompanyName("Skate Parts Source");
            pennyDeck.setMinInv(1);
            pennyDeck.setMaxInv(30);
            // adding object to parts repository
            outsourcedPartRepository.save(pennyDeck);

            // creating object from Part class
            OutsourcedPart pintailDeck = new OutsourcedPart();
            // setting values
            pintailDeck.setName("Pintail Deck");
            pintailDeck.setInv(15);
            pintailDeck.setPrice(20.00);
            pintailDeck.setCompanyName("Skate Parts Source");
            pintailDeck.setMinInv(1);
            pintailDeck.setMaxInv(30);
            // adding object to parts repository
            outsourcedPartRepository.save(pintailDeck);
        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart outsourcedPart:outsourcedParts) {
            System.out.println(outsourcedPart.getName() + " " + outsourcedPart.getCompanyName());
        }
        List<InhousePart> inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
        for(InhousePart inhousePart:inhouseParts){
            System.out.println(inhousePart.getName()+" ");
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        // creating objects from the product class
        if (productRepository.count() == 0) {
            Product classic = new Product("The Classic", 40.00, 10);
            productRepository.save(classic);

            Product lowProfile = new Product("The Low Profile", 35.00, 5);
            productRepository.save(lowProfile);

            Product carver = new Product("The Carver", 50.00, 10);
            productRepository.save(carver);

            Product styler = new Product("The Styler", 45.00, 10);
            productRepository.save(styler);

            Product traveller = new Product("The Traveller", 45.00, 10);
            productRepository.save(traveller);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
