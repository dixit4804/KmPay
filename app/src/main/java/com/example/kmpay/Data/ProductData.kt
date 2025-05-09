package com.example.kmpay.Data

import com.example.kmpay.R

object ProductData {
    val productList = listOf(
        Product(
            id = 1,
            name = "Running Shoes",
            price = 360,
            image = R.drawable.shoes,
            details = "Professional running shoes with advanced cushioning technology",
            warranty = "1 year manufacturing defects",
            rating = 3.5f,
            specifications = listOf(
                "Material: Breathable mesh upper",
                "Sole: High-rebound EVA foam",
                "Weight: 280g per shoe",
                "Sizes: US 6-13",
                "Colors: Black/Red, White/Blue"
            ),
            features = listOf(
                "Shock-absorbing heel cushion",
                "Anti-slip rubber outsole",
                "Removable orthotic insoles"
            ),
            includedItems = listOf("Shoes", "Extra laces", "Dust bag"),
            returnPolicy = "30-day free returns"
        ),

        Product(
            id = 2,
            name = "Men's Slippers",
            price = 149,
            image = R.drawable.mensliper,
            details = "Ultra-soft memory foam slippers for indoor comfort",
            warranty = "6 months sole separation",
            rating = 4.2f,
            specifications = listOf(
                "Material: Cotton terry upper",
                "Footbed: 2cm memory foam",
                "Sizes: S-XXL",
                "Colors: Grey, Navy, Black"
            ),
            features = listOf(
                "Anti-skid rubber dots",
                "Breathable fabric lining"
            ),
            includedItems = listOf("1 pair of slippers"),
            returnPolicy = "15-day returns"
        ),

        Product(
            id = 3,
            name = "Women's Sandals",
            price = 259,
            image = R.drawable.womensandal,
            details = "Comfortable leather sandals with arch support",
            warranty = "1 year craftsmanship",
            rating = 4.0f,
            specifications = listOf(
                "Material: Genuine leather",
                "Footbed: Cushioned EVA",
                "Sizes: US 5-10",
                "Width: Medium"
            ),
            features = listOf(
                "Adjustable ankle straps",
                "Lightweight: 220g per pair"
            ),
            includedItems = listOf("Sandals", "Dust bag"),
            returnPolicy = "30-day free returns"
        ),

        Product(
            id = 4,
            name = "Men's Formal Shirt",
            price = 299,
            image = R.drawable.mentshirt,
            details = "Premium cotton formal shirt with wrinkle-resistant finish",
            warranty = "None",
            rating = 3.5f,
            specifications = listOf(
                "Material: 100% Egyptian cotton",
                "Care: Machine wash cold",
                "Sizes: S-XXL",
                "Colors: White, Blue, Black"
            ),
            features = listOf(
                "Spread collar design",
                "Single button cuffs",
                "Tailored fit"
            ),
            includedItems = listOf("Shirt"),
            returnPolicy = "14-day returns"
        ),

        Product(
            id = 5,
            name = "Women's Blouse",
            price = 349,
            image = R.drawable.woementshirt,
            details = "Elegant silk-blend blouse with delicate embroidery",
            warranty = "None",
            rating = 4.4f,
            specifications = listOf(
                "Material: 70% silk, 30% cotton",
                "Care: Dry clean only",
                "Sizes: XS-XL",
                "Pattern: Floral"
            ),
            features = listOf(
                "V-neck design",
                "French cuffs",
                "Semi-sheer fabric"
            ),
            includedItems = listOf("Blouse"),
            returnPolicy = "14-day returns"
        ),

        Product(
            id = 6,
            name = "Men's Pants",
            price = 599,
            image = R.drawable.men_pents,
            details = "Classic fit chino pants with stretch fabric",
            warranty = "None",
            rating = 4.5f,
            specifications = listOf(
                "Material: 98% cotton, 2% spandex",
                "Care: Machine wash",
                "Waist: 28-40 inches",
                "Inseam: 30-34 inches"
            ),
            features = listOf(
                "Flat front design",
                "Belt loops",
                "Wrinkle-resistant"
            ),
            includedItems = listOf("Pants"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 7,
            name = "Bluetooth Speaker",
            price = 1099,
            image = R.drawable.speaker,
            details = "Portable waterproof speaker with 20-hour battery",
            warranty = "2 years limited",
            rating = 4.7f,
            specifications = listOf(
                "Output: 20W RMS",
                "Battery: 4000mAh",
                "Bluetooth: 5.0",
                "Waterproof: IPX7"
            ),
            features = listOf(
                "Party pairing mode",
                "Built-in microphone",
                "Bass boost"
            ),
            includedItems = listOf("Speaker", "USB-C cable", "Manual"),
            returnPolicy = "1-year replacement"
        ),

        Product(
            id = 8,
            name = "Headphones",
            price = 1690,
            image = R.drawable.headphone,
            details = "Noise-cancelling over-ear headphones",
            warranty = "2 years",
            rating = 4.2f,
            specifications = listOf(
                "Driver: 40mm",
                "Battery: 30hrs",
                "Weight: 255g",
                "Bluetooth: 5.0"
            ),
            features = listOf(
                "Active noise cancellation",
                "Foldable design",
                "Touch controls"
            ),
            includedItems = listOf("Headphones", "Case", "Cables"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 9,
            name = "Game Console",
            price = 3499,
            image = R.drawable.game_player,
            details = "Next-gen 4K gaming console with 1TB storage",
            warranty = "3 years",
            rating = 4.1f,
            specifications = listOf(
                "CPU: 8-core Zen 2",
                "GPU: 10.28 TFLOPs",
                "Storage: 1TB SSD",
                "Resolution: 4K/120fps"
            ),
            features = listOf(
                "Backward compatible",
                "Ray tracing",
                "Ultra HD Blu-ray"
            ),
            includedItems = listOf("Console", "Controller", "HDMI cable"),
            returnPolicy = "30-day replacement"
        ),

        Product(
            id = 10,
            name = "Smart Watch",
            price = 1299,
            image = R.drawable.smart_watch,
            details = "Fitness tracker with heart rate monitor",
            warranty = "1 year",
            rating = 4.6f,
            specifications = listOf(
                "Display: 1.4\" AMOLED",
                "Battery: 7 days",
                "Waterproof: 5ATM",
                "Sensors: GPS, HR, SpO2"
            ),
            features = listOf(
                "200+ workout modes",
                "Sleep tracking",
                "NFC payments"
            ),
            includedItems = listOf("Watch", "Charger", "Bands"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 11,
            name = "Wireless Earbuds",
            price = 1400,
            image = R.drawable.earbud,
            details = "True wireless earbuds with 8hr battery",
            warranty = "1 year",
            rating = 4.5f,
            specifications = listOf(
                "Driver: 10mm",
                "Battery: 8hr + 24hr case",
                "Bluetooth: 5.2",
                "Weight: 5g per earbud"
            ),
            features = listOf(
                "Active noise cancellation",
                "IPX5 waterproof",
                "Touch controls"
            ),
            includedItems = listOf("Earbuds", "Charging case", "Tips"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 12,
            name = "Printer",
            price = 12999,
            image = R.drawable.printer,
            details = "All-in-one color inkjet printer",
            warranty = "2 years",
            rating = 4.3f,
            specifications = listOf(
                "Print speed: 15ppm",
                "Resolution: 4800x1200 dpi",
                "Connectivity: WiFi, USB",
                "Paper sizes: A4, Letter"
            ),
            features = listOf(
                "Scan/copy/fax",
                "Auto duplex printing",
                "Mobile printing"
            ),
            includedItems = listOf("Printer", "Starter ink", "Cables"),
            returnPolicy = "30-day replacement"
        ),

        Product(
            id = 15,
            name = "Air Fryer",
            price = 6599,
            image = R.drawable.airfryer,
            details = "5.8L digital air fryer with 8 presets",
            warranty = "2 years",
            rating = 4.7f,
            specifications = listOf(
                "Capacity: 5.8L",
                "Power: 1700W",
                "Temperature: 80-200°C",
                "Timer: 60 mins"
            ),
            features = listOf(
                "Oil-free cooking",
                "Auto shut-off",
                "Dishwasher-safe"
            ),
            includedItems = listOf("Air fryer", "Basket", "Manual"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 17,
            name = "Iron",
            price = 350,
            image = R.drawable.iron,
            details = "2000W steam iron with ceramic soleplate",
            warranty = "1 year",
            rating = 4.4f,
            specifications = listOf(
                "Power: 2000W",
                "Water tank: 300ml",
                "Steam: 30g/min",
                "Weight: 1.8kg"
            ),
            features = listOf(
                "Anti-drip system",
                "Auto clean",
                "Vertical steam"
            ),
            includedItems = listOf("Iron", "Measuring cup"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 19,
            name = "Oven",
            price = 4500,
            image = R.drawable.oven,
            details = "25L convection microwave oven",
            warranty = "2 years",
            rating = 4.1f,
            specifications = listOf(
                "Capacity: 25L",
                "Power: 900W microwave + 1200W grill",
                "Modes: 10 auto cook",
                "Turntable: 31.5cm"
            ),
            features = listOf(
                "Grill + convection",
                "Child lock",
                "Defrost function"
            ),
            includedItems = listOf("Oven", "Rack", "Tray"),
            returnPolicy = "30-day replacement"
        ),

        Product(
            id = 20,
            name = "Fan",
            price = 3500,
            image = R.drawable.fan,
            details = "16-inch 3-speed table fan",
            warranty = "1 year",
            rating = 4.2f,
            specifications = listOf(
                "Size: 16-inch blades",
                "Speeds: 3",
                "Power: 50W",
                "Noise: <55dB"
            ),
            features = listOf(
                "Tilt adjustment",
                "Overheat protection",
                "Easy-grip handle"
            ),
            includedItems = listOf("Fan", "Base"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 22,
            name = "Cookware Set",
            price = 600,
            image = R.drawable.kadai,
            details = "5-piece non-stick cookware set",
            warranty = "5 years",
            rating = 4.5f,
            specifications = listOf(
                "Material: Hard-anodized aluminum",
                "Pieces: 5",
                "Induction: Compatible",
                "Oven safe: 250°C"
            ),
            features = listOf(
                "Stay-cool handles",
                "Even heat distribution",
                "Dishwasher safe"
            ),
            includedItems = listOf("Pans", "Lids", "Spatula"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 23,
            name = "Sofa",
            price = 13000,
            image = R.drawable.sofa,
            details = "3-seater fabric sofa with wood frame",
            warranty = "5 years frame",
            rating = 4.7f,
            specifications = listOf(
                "Dimensions: 210×90×75cm",
                "Weight: 45kg",
                "Material: Polyester fabric",
                "Color: Grey"
            ),
            features = listOf(
                "Removable covers",
                "Pocket spring cushions",
                "Anti-slip feet"
            ),
            includedItems = listOf("Sofa", "Cushions", "Tools"),
            returnPolicy = "14-day in-home returns"
        ),

        Product(
            id = 24,
            name = "Sofa Set",
            price = 17000,
            image = R.drawable.sofaa,
            details = "2-seater loveseat with matching pillows",
            warranty = "3 years",
            rating = 4.6f,
            specifications = listOf(
                "Dimensions: 160×85×70cm",
                "Weight: 35kg",
                "Material: Microfiber",
                "Color: Beige"
            ),
            features = listOf(
                "Reversible cushions",
                "Solid wood legs",
                "Easy assembly"
            ),
            includedItems = listOf("Sofa", "Pillows", "Tools"),
            returnPolicy = "14-day in-home returns"
        ),

        Product(
            id = 25,
            name = "Dining Table",
            price =8000,
            image = R.drawable.dinning_table,
            details = "6-seater wooden dining table",
            warranty = "5 years",
            rating = 4.8f,
            specifications = listOf(
                "Dimensions: 180×90×75cm",
                "Weight: 60kg",
                "Material: Solid oak",
                "Extendable: No"
            ),
            features = listOf(
                "Scratch-resistant",
                "Waterproof coating",
                "Chairs sold separately"
            ),
            includedItems = listOf("Table", "Care kit"),
            returnPolicy = "14-day in-home returns"
        ),

        Product(
            id = 26,
            name = "Bed",
            price = 22000,
            image = R.drawable.bed,
            details = "Queen size wooden bed frame",
            warranty = "10 years",
            rating = 4.9f,
            specifications = listOf(
                "Dimensions: 160×200cm",
                "Weight: 50kg",
                "Material: Solid pine",
                "Headboard: Included"
            ),
            features = listOf(
                "Underbed storage",
                "Slat base",
                "Tool-free assembly"
            ),
            includedItems = listOf("Bed frame", "Slats", "Tools"),
            returnPolicy = "14-day in-home returns"
        ),

        Product(
            id = 27,
            name = "Bedsheet",
            price = 259,
            image = R.drawable.bedsheet,
            details = "100% cotton 4-piece bedsheet set",
            warranty = "None",
            rating = 4.5f,
            specifications = listOf(
                "Size: Queen",
                "Material: 400TC cotton",
                "Colors: White, Blue, Grey",
                "Care: Machine wash"
            ),
            features = listOf(
                "Deep pockets",
                "Wrinkle-resistant",
                "Oeko-Tex certified"
            ),
            includedItems = listOf("Fitted sheet", "Flat sheet", "Pillowcases"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 28,
            name = "Wardrobe",
            price = 4999,
            image = R.drawable.almira,
            details = "6-door wooden wardrobe with mirror",
            warranty = "5 years",
            rating = 4.7f,
            specifications = listOf(
                "Dimensions: 180×200×60cm",
                "Weight: 80kg",
                "Material: Engineered wood",
                "Color: White"
            ),
            features = listOf(
                "Full-length mirror",
                "Adjustable shelves",
                "Hanging rail"
            ),
            includedItems = listOf("Wardrobe", "Shelves", "Tools"),
            returnPolicy = "14-day in-home returns"
        ),

        Product(
            id = 29,
            name = "Bookshelf",
            price = 1449,
            image = R.drawable.almia2,
            details = "5-tier wooden bookshelf",
            warranty = "2 years",
            rating = 4.6f,
            specifications = listOf(
                "Dimensions: 80×180×30cm",
                "Weight: 25kg",
                "Material: Pine wood",
                "Load capacity: 50kg"
            ),
            features = listOf(
                "Adjustable shelves",
                "Wall-mountable",
                "Open back design"
            ),
            includedItems = listOf("Bookshelf", "Shelves", "Hardware"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 30,
            name = "Novel Collection",
            price = 299,
            image = R.drawable.book,
            details = "Bestseller novel set (3 books)",
            warranty = "None",
            rating = 4.8f,
            specifications = listOf(
                "Format: Paperback",
                "Pages: 300-400 per book",
                "Language: English",
                "Publisher: Penguin"
            ),
            features = listOf(
                "Author-signed bookplate",
                "Collector's edition",
                "Bonus short story"
            ),
            includedItems = listOf("3 books", "Bookmark"),
            returnPolicy = "Non-returnable"
        ),

        Product(
            id = 31,
            name = "Cookbook",
            price = 399,
            image = R.drawable.book2,
            details = "Professional chef's cookbook collection",
            warranty = "None",
            rating = 4.7f,
            specifications = listOf(
                "Format: Hardcover",
                "Pages: 500",
                "Recipes: 200+",
                "Cuisine: International"
            ),
            features = listOf(
                "Step-by-step photos",
                "Meal plans",
                "Nutrition info"
            ),
            includedItems = listOf("Cookbook"),
            returnPolicy = "Non-returnable"
        ),

        Product(
            id = 32,
            name = "Mountain Bike",
            price = 9999,
            image = R.drawable.cycle,
            details = "21-speed aluminum frame mountain bike",
            warranty = "1 year",
            rating = 4.9f,
            specifications = listOf(
                "Frame: Aluminum",
                "Gears: 21-speed",
                "Wheels: 26-inch",
                "Weight: 14kg"
            ),
            features = listOf(
                "Front suspension",
                "Disc brakes",
                "Quick-release wheels"
            ),
            includedItems = listOf("Bike", "Tools", "Manual"),
            returnPolicy = "30-day assembly returns"
        ),

        Product(
            id = 33,
            name = "Bike Helmet",
            price = 1799,
            image = R.drawable.helmet,
            details = "Ventilated cycling helmet with MIPS",
            warranty = "1 year",
            rating = 4.7f,
            specifications = listOf(
                "Size: M (54-58cm)",
                "Weight: 300g",
                "Certification: CE EN1078",
                "Vents: 18"
            ),
            features = listOf(
                "MIPS protection",
                "Adjustable fit system",
                "Removable padding"
            ),
            includedItems = listOf("Helmet"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 34,
            name = "Cycling Gloves",
            price = 199,
            image = R.drawable.gloves,
            details = "Padded cycling gloves",
            warranty = "None",
            rating = 4.5f,
            specifications = listOf(
                "Size: M",
                "Material: Synthetic leather",
                "Padding: Gel",
                "Touchscreen: Yes"
            ),
            features = listOf(
                "Breathable mesh",
                "Anti-slip palm",
                "Wrist closure"
            ),
            includedItems = listOf("Pair of gloves"),
            returnPolicy = "30-day returns"
        ),

        Product(
            id = 35,
            name = "Tennis Racket",
            price = 754,
            image = R.drawable.racket,
            details = "Professional graphite tennis racket",
            warranty = "1 year",
            rating = 4.6f,
            specifications = listOf(
                "Weight: 300g",
                "Head size: 100sq.in",
                "Grip: 4 3/8",
                "String pattern: 16×19"
            ),
            features = listOf(
                "Vibration dampener",
                "Pre-strung",
                "Head light balance"
            ),
            includedItems = listOf("Racket", "Cover"),
            returnPolicy = "30-day returns"
        )
    )
}