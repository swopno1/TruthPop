package com.example.data

import com.example.model.GameCategory
import com.example.model.Intensity
import com.example.model.PromptItem
import com.example.model.PromptType

object PromptRepository {

    val prompts: List<PromptItem> = listOf(
        // ==========================================
        // FRIENDS - CHILL
        // ==========================================
        PromptItem(
            id = "f_c_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "What is the weirdest food combination that you secretly love?",
            textBn = "কোন অদ্ভুত খাবারের কম্বিনেশনটা তোমার গোপনে খুব পছন্দ?",
            hintEn = "Be honest about that weird snack!",
            hintBn = "লুকোনো স্ন্যাক্স নিয়ে সত্যি বলো!"
        ),
        PromptItem(
            id = "f_c_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "What is the last thing you searched for on your phone?",
            textBn = "ফোনে সর্বশেষ কী সার্চ করেছিলে?",
            hintEn = "No deleting history first!",
            hintBn = "হিস্ট্রি ডিলিট না করে বলো!"
        ),
        PromptItem(
            id = "f_c_t_3",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "If you could trade lives with one person in this room for 24 hours, who would it be?",
            textBn = "এই ঘরের কারও সাথে ২৪ ঘণ্টার জন্য জীবন অদলবদল করতে পারলে কাকে বেছে নিতে?",
            hintEn = "Tell us why too!",
            hintBn = "কারণটাও বলো!"
        ),
        PromptItem(
            id = "f_c_t_4",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "What childish thing do you still secretly enjoy doing?",
            textBn = "ছোটবেলার কোন কাজটা তুমি এখনো গোপনে খুব উপভোগ করো?",
            hintEn = "Cartoons, cereal, or jumping on beds?",
            hintBn = "কার্টুন নাকি বিছানায় লাফানো?"
        ),
        PromptItem(
            id = "f_c_t_5",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "What is your biggest irrational fear?",
            textBn = "তোমার সবচেয়ে অযৌক্তিক বা অদ্ভুত ভয় কোনটি?",
            hintEn = "Pigeons, elevators, or shadows?",
            hintBn = "কবুতর, লিফট নাকি ছায়া?"
        ),
        PromptItem(
            id = "f_c_d_1",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "Speak in an exaggerated accent of your choice for the next two rounds.",
            textBn = "পরবর্তী দুই রাউন্ড যেকোনো একটি মজার আঞ্চলিক বা বিদেশি টানে কথা বলো।",
            hintEn = "Keep the accent consistent!",
            hintBn = "টানটা বজায় রাখো!"
        ),
        PromptItem(
            id = "f_c_d_2",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "Do your best impression of another player in the group until someone guesses who it is.",
            textBn = "গ্রুপের অন্য একজন বন্ধুর হুবহু অনুকরণ করো যতক্ষণ না কেউ চিনে ফেলে।",
            hintEn = "Mimic their signature gesture!",
            hintBn = "তার বিশেষ ভঙ্গি নকল করো!"
        ),
        PromptItem(
            id = "f_c_d_3",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "Show the group the funniest photo or meme currently saved in your camera roll.",
            textBn = "তোমার ফোনের গ্যালারিতে সেভ করা সবচেয়ে মজার ছবি বা মিমটি সবাইকে দেখাও।",
            hintEn = "No filtering the silliness!",
            hintBn = "সবচেয়ে হাসির ছবিটাই দেখাও!"
        ),
        PromptItem(
            id = "f_c_d_4",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL,
            textEn = "Balance a spoon or small object on your nose for 20 seconds.",
            textBn = "তোমার নাকের উপর ২০ সেকেন্ডের জন্য একটি চামচ বা ছোট বস্তু ব্যালেন্স করো।",
            hintEn = "Tilt your head slightly back!",
            hintBn = "মাথা একটু পেছনে হেলাও!"
        ),

        // ==========================================
        // FRIENDS - FUN
        // ==========================================
        PromptItem(
            id = "f_f_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.FUN,
            textEn = "What is the most awkward lie you ever told to cancel plans with a friend?",
            textBn = "বন্ধুর সাথে দেখা বাতিল করতে গিয়ে সবচেয়ে অদ্ভুত কোন মিথ্যাটি বলেছিলে?",
            hintEn = "We will not judge... much!",
            hintBn = "আমরা বেশি বিচার করব না!"
        ),
        PromptItem(
            id = "f_f_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.FUN,
            textEn = "Who was your most embarrassing childhood celebrity crush?",
            textBn = "ছোটবেলায় তোমার সবচেয়ে অদ্ভুত বা লজ্জাজনক সেলিব্রিটি ক্রাশ কে ছিল?",
            hintEn = "Own the nostalgia!",
            hintBn = "খুলে বলো!"
        ),
        PromptItem(
            id = "f_f_t_3",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.FUN,
            textEn = "What is the silliest fashion choice you made in the past that you now regret?",
            textBn = "অতীতে করা তোমার সবচেয়ে বিদঘুটে ফ্যাশন চয়েস কোনটি যা এখন মনে পড়লে লজ্জা পাও?",
            hintEn = "Haircuts or outfit disasters count!",
            hintBn = "অদ্ভুত হেয়ারকাট বা ড্রেস!"
        ),
        PromptItem(
            id = "f_f_t_4",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.FUN,
            textEn = "If you had to delete every social app except one forever, which one survives?",
            textBn = "যদি একটি ছাড়া সব সোশ্যাল মিডিয়া অ্যাপ মুছে ফেলতে হয়, তবে কোনটি রাখবে?",
            hintEn = "Pick wisely!",
            hintBn = "ভেবেচিন্তে নির্বাচন করো!"
        ),
        PromptItem(
            id = "f_f_d_1",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.FUN,
            textEn = "Send a random voice note to a friend singing the chorus of 'Happy Birthday' dramatically.",
            textBn = "যেকোনো একজন বন্ধুকে নাটকীয় সুরে 'হ্যাপি বার্থডে' গেয়ে ভয়েস মেসেজ পাঠাও।",
            hintEn = "Operatic or rock style!",
            hintBn = "নাটকীয় স্টাইলে গাও!"
        ),
        PromptItem(
            id = "f_f_d_2",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.FUN,
            textEn = "Let the player to your right compose a funny status update on your social profile or story.",
            textBn = "তোমার ডানপাশের বন্ধুকে তোমার জন্য একটি মজার স্ট্যাটাস বা স্টোরি লিখতে দাও।",
            hintEn = "Friendly jokes only!",
            hintBn = "মজার এবং নির্দোষ কথা!"
        ),
        PromptItem(
            id = "f_f_d_3",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.FUN,
            textEn = "Do 15 quick jumping jacks while enthusiastically announcing each number in another language.",
            textBn = "অন্য যেকোনো ভাষায় জোরে জোরে সংখ্যা গুনে ১৫টি জাম্পিং জ্যাক করো।",
            hintEn = "Spanish, French, or Japanese!",
            hintBn = "উৎসাহের সাথে গণনা করো!"
        ),
        PromptItem(
            id = "f_f_d_4",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.FUN,
            textEn = "Hold a staring contest with the person opposite you without blinking or smiling for 30 seconds.",
            textBn = "সামনে থাকা বন্ধুর দিকে পলক বা হাসি না ফেলে ৩০ সেকেন্ড তাকিয়ে থাকো।",
            hintEn = "Try not to crack a smile!",
            hintBn = "হাসি আটকে রাখো!"
        ),

        // ==========================================
        // FRIENDS - SPICY
        // ==========================================
        PromptItem(
            id = "f_s_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.SPICY,
            textEn = "Have you ever stalked an ex or a crush on social media using a fake burner account?",
            textBn = "তুমি কি কখনো ভুয়া অ্যাকাউন্ট দিয়ে তোমার ক্রাশ বা প্রাক্তনের প্রোফাইল স্টক করেছ?",
            hintEn = "Confess the detective skills!",
            hintBn = "গোয়েন্দাগিরির কথা স্বীকার করো!"
        ),
        PromptItem(
            id = "f_s_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.SPICY,
            textEn = "What was the biggest rumor about yourself that turned out to be completely true?",
            textBn = "তোমাকে নিয়ে ছড়ানো সবচেয়ে বড় কোন গুজবটি পুরোপুরি সত্যি ছিল?",
            hintEn = "Spill the tea!",
            hintBn = "আসল ঘটনাটি বলো!"
        ),
        PromptItem(
            id = "f_s_t_3",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.SPICY,
            textEn = "Who in this room would you least trust to hold your unlocked phone for 10 minutes?",
            textBn = "এই ঘরের কার হাতে ১০ মিনিটের জন্য আনলক করা ফোন দিতে তুমি সবচেয়ে বেশি ভয় পাবে?",
            hintEn = "Point them out gently!",
            hintBn = "কারণসহ নাম বলো!"
        ),
        PromptItem(
            id = "f_s_t_4",
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.SPICY,
            textEn = "What is something you pretended to like just to impress someone you had feelings for?",
            textBn = "কারও মন পাওয়ার জন্য তুমি এমন কোন জিনিস ভালোবাসার ভান করেছিলে যা আসলে তোমার অপছন্দ?",
            hintEn = "Music, books, or sports?",
            hintBn = "গান, সিনেমা বা খেলাধুলা?"
        ),
        PromptItem(
            id = "f_s_d_1",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.SPICY,
            textEn = "Let the group scroll through your recently deleted photo album for 20 seconds.",
            textBn = "গ্রুপের বন্ধুদেরকে ২০ সেকেন্ডের জন্য তোমার রিসেন্টলি ডিলিটেড অ্যালবাম দেখতে দাও।",
            hintEn = "Nothing scandalous, just the bloopers!",
            hintBn = "ভুল তোলা সেলফিগুলো দেখাও!"
        ),
        PromptItem(
            id = "f_s_d_2",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.SPICY,
            textEn = "Call your closest friend who is not here and tell them you just won a trip to Paris, then yell 'April Fools'!",
            textBn = "যে বন্ধুটি এখানে নেই তাকে কল দিয়ে বলো তুমি প্যারিস ভ্রমণের লটারি জিতেছ, তারপর বলো এপ্রিল ফুল!",
            hintEn = "Keep a straight voice for 30 seconds!",
            hintBn = "কিছুক্ষণ গম্ভীর থাকো!"
        ),
        PromptItem(
            id = "f_s_d_3",
            type = PromptType.DARE,
            category = GameCategory.FRIENDS,
            intensity = Intensity.SPICY,
            textEn = "Exchange one shoe with the person on your left and wear it for the next 3 rounds.",
            textBn = "তোমার বামপাশের বন্ধুর সাথে একটি জুতো বদল করে আগামী ৩ রাউন্ড পরে থাকো।",
            hintEn = "Mismatched fashion icon!",
            hintBn = "নতুন স্টাইল!"
        ),

        // ==========================================
        // COUPLES - CHILL
        // ==========================================
        PromptItem(
            id = "c_c_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.COUPLES,
            intensity = Intensity.CHILL,
            textEn = "What was the very first thought that crossed your mind the first time we met?",
            textBn = "প্রথমবার যখন আমাদের দেখা হয়েছিল তখন আমার সম্পর্কে তোমার প্রথম কী ধারণা হয়েছিল?",
            hintEn = "First impressions always count!",
            hintBn = "প্রথম দেখার অনুভূতি!"
        ),
        PromptItem(
            id = "c_c_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.COUPLES,
            intensity = Intensity.CHILL,
            textEn = "Which quirky little habit of mine do you secretly find adorable?",
            textBn = "আমার কোন অদ্ভুত ছোট অভ্যাসটি তোমার গোপনে খুব মিষ্টি লাগে?",
            hintEn = "Think of everyday quirks!",
            hintBn = "প্রতিদিনের ছোট কোনো অভ্যাস!"
        ),
        PromptItem(
            id = "c_c_t_3",
            type = PromptType.TRUTH,
            category = GameCategory.COUPLES,
            intensity = Intensity.CHILL,
            textEn = "What is your dream vacation destination for just the two of us?",
            textBn = "শুধু আমাদের দুজনের জন্য তোমার স্বপ্নের ছুটির গন্তব্য কোনটি?",
            hintEn = "Beach, mountains, or historic cities?",
            hintBn = "সমুদ্র, পাহাড় নাকি কোনো শহর?"
        ),
        PromptItem(
            id = "c_c_d_1",
            type = PromptType.DARE,
            category = GameCategory.COUPLES,
            intensity = Intensity.CHILL,
            textEn = "Give your partner a 60-second gentle shoulder massage while playing soothing instrumental music.",
            textBn = "শান্ত মিউজিক বাজিয়ে তোমার সঙ্গীকে ৬০ সেকেন্ডের আরামদায়ক শোল্ডার ম্যাসাজ দাও।",
            hintEn = "Focus on the neck and shoulders!",
            hintBn = "ঘাড় ও কাঁধে আরাম দাও!"
        ),
        PromptItem(
            id = "c_c_d_2",
            type = PromptType.DARE,
            category = GameCategory.COUPLES,
            intensity = Intensity.CHILL,
            textEn = "Recreate our first photo together using your phone's front camera right now.",
            textBn = "আমাদের একসাথে তোলা প্রথম ছবির পোজটি এখনই সেলফি তুলে হুবহু অনুকরণ করো।",
            hintEn = "Copy the same facial expressions!",
            hintBn = "একই মুখের অভিব্যক্তি রাখো!"
        ),

        // ==========================================
        // COUPLES - FUN
        // ==========================================
        PromptItem(
            id = "c_f_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.COUPLES,
            intensity = Intensity.FUN,
            textEn = "What is the most ridiculous argument we ever had that makes you laugh today?",
            textBn = "আমাদের মধ্যে হওয়া সবচেয়ে হাস্যকর ঝগড়া কোনটি যা মনে পড়লে আজ হাসি পায়?",
            hintEn = "Where to eat? Lost keys?",
            hintBn = "খাবার পছন্দ নিয়ে নাকি হারিয়ে যাওয়া চাবি নিয়ে?"
        ),
        PromptItem(
            id = "c_f_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.COUPLES,
            intensity = Intensity.FUN,
            textEn = "If our relationship were a movie genre, which one would it be and why?",
            textBn = "আমাদের সম্পর্ক যদি কোনো সিনেমার ধরন হতো, তবে সেটা কী হতো এবং কেন?",
            hintEn = "Rom-com, adventure, or musical?",
            hintBn = "রোমান্টিক কমেডি নাকি অ্যাডভেঞ্চার?"
        ),
        PromptItem(
            id = "c_f_d_1",
            type = PromptType.DARE,
            category = GameCategory.COUPLES,
            intensity = Intensity.FUN,
            textEn = "Serenade your partner with a popular romantic song using dramatic hand gestures.",
            textBn = "নাটকীয় হাতের ভঙ্গি দিয়ে তোমার সঙ্গীর উদ্দেশ্যে একটি রোমান্টিক গান গেয়ে শোনাও।",
            hintEn = "Full Broadway enthusiasm!",
            hintBn = "পুরো আবেগের সাথে গাও!"
        ),
        PromptItem(
            id = "c_f_d_2",
            type = PromptType.DARE,
            category = GameCategory.COUPLES,
            intensity = Intensity.FUN,
            textEn = "Write a sweet 4-line rhyming poem about your partner in under 90 seconds and recite it.",
            textBn = "দেড় মিনিটের মধ্যে সঙ্গীকে নিয়ে ৪ লাইনের মিষ্টি ছড়া বা কবিতা লিখে আবৃত্তি করো।",
            hintEn = "Rhyme time!",
            hintBn = "ছন্দ মিলিয়ে বলো!"
        ),

        // ==========================================
        // COUPLES - SPICY
        // ==========================================
        PromptItem(
            id = "c_s_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.COUPLES,
            intensity = Intensity.SPICY,
            textEn = "What is one romantic surprise you have always fantasized about receiving?",
            textBn = "এমন কোন রোমান্টিক সারপ্রাইজ আছে যা তুমি সবসময় পাওয়ার স্বপ্ন দেখতে?",
            hintEn = "Candlelight dinner, surprise getaway?",
            hintBn = "মোমবাতি জ্বালানো ডিনার নাকি আচমকা ভ্রমণ?"
        ),
        PromptItem(
            id = "c_s_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.COUPLES,
            intensity = Intensity.SPICY,
            textEn = "What outfit or style does your partner wear that makes your heart race the fastest?",
            textBn = "সঙ্গীর কোন পোশাক বা সাজগোজ দেখলে তোমার হৃদস্পন্দন সবচেয়ে দ্রুত হয়?",
            hintEn = "Traditional, casual, or formal?",
            hintBn = "ট্রেডিশনাল নাকি ফরমাল?"
        ),
        PromptItem(
            id = "c_s_d_1",
            type = PromptType.DARE,
            category = GameCategory.COUPLES,
            intensity = Intensity.SPICY,
            textEn = "Whisper three genuinely romantic compliments into your partner's ear slowly.",
            textBn = "সঙ্গীর কানের কাছে গিয়ে ধীরে ধীরে তিনটি মন থেকে দেওয়া রোমান্টিক প্রশংসা করো।",
            hintEn = "Look into their eyes right after!",
            hintBn = "চোখে চোখ রেখে বলো!"
        ),
        PromptItem(
            id = "c_s_d_2",
            type = PromptType.DARE,
            category = GameCategory.COUPLES,
            intensity = Intensity.SPICY,
            textEn = "Slow dance with your partner for one full minute with no background music playing.",
            textBn = "কোনো মিউজিক ছাড়াই পুরো এক মিনিট তোমার সঙ্গীর সাথে স্লো ড্যান্স করো।",
            hintEn = "Hold each other close!",
            hintBn = "স্নিগ্ধভাবে নাচো!"
        ),

        // ==========================================
        // FAMILY - CHILL
        // ==========================================
        PromptItem(
            id = "fam_c_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.FAMILY,
            intensity = Intensity.CHILL,
            textEn = "Who makes the most delicious dish in the family, and what dish is it?",
            textBn = "পরিবারে কার হাতের রান্না সবচেয়ে সেরা এবং কোন খাবারটি সবচেয়ে প্রিয়?",
            hintEn = "Give credit to the chef!",
            hintBn = "রাঁধুনির প্রশংসা করো!"
        ),
        PromptItem(
            id = "fam_c_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.FAMILY,
            intensity = Intensity.CHILL,
            textEn = "What is your fondest memory from a past family road trip or festival celebration?",
            textBn = "অতীতের কোনো পারিবারিক ভ্রমণ বা উৎসবের সবচেয়ে প্রিয় স্মৃতি কোনটি?",
            hintEn = "Share the joy!",
            hintBn = "আনন্দের গল্প বলো!"
        ),
        PromptItem(
            id = "fam_c_t_3",
            type = PromptType.TRUTH,
            category = GameCategory.FAMILY,
            intensity = Intensity.CHILL,
            textEn = "If our family had a family motto or superhero team name, what should it be?",
            textBn = "আমাদের পরিবারের যদি একটি সুপারহিরো টিম নাম থাকত, তবে সেটা কী হতো?",
            hintEn = "Creative and fun!",
            hintBn = "মজার কোনো নাম!"
        ),
        PromptItem(
            id = "fam_c_d_1",
            type = PromptType.DARE,
            category = GameCategory.FAMILY,
            intensity = Intensity.CHILL,
            textEn = "Give everyone in the room a warm high-five and tell each person one thing you appreciate about them.",
            textBn = "ঘরের সবাইকে হাই-ফাইভ দাও এবং প্রত্যেকের একটি ভালো গুণের প্রশংসা করো।",
            hintEn = "Spread the family warmth!",
            hintBn = "ভালোবাসা ছড়াও!"
        ),
        PromptItem(
            id = "fam_c_d_2",
            type = PromptType.DARE,
            category = GameCategory.FAMILY,
            intensity = Intensity.CHILL,
            textEn = "Do your best impression of your favorite animal sound and walk across the room like them.",
            textBn = "তোমার প্রিয় পশুর ডাক ডেকে তার মতো হেঁটে ঘরের এক প্রান্ত থেকে অন্য প্রান্তে যাও।",
            hintEn = "Penguin, tiger, or frog!",
            hintBn = "পেঙ্গুইন, বাঘ নাকি ব্যাঙ!"
        ),

        // ==========================================
        // FAMILY - FUN
        // ==========================================
        PromptItem(
            id = "fam_f_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.FAMILY,
            intensity = Intensity.FUN,
            textEn = "What household chore do you secretly despise doing the most?",
            textBn = "ঘরের কোন কাজটা করতে তোমার সবচেয়ে বেশি বিরক্তি লাগে?",
            hintEn = "Dishes, trash, or folding laundry?",
            hintBn = "বাসন মাজা, ময়লা ফেলা নাকি কাপড় গোছানো?"
        ),
        PromptItem(
            id = "fam_f_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.FAMILY,
            intensity = Intensity.FUN,
            textEn = "Who in the family is the loudest sleeper or snores the most?",
            textBn = "পরিবারে কার ঘুমের শব্দ বা নাক ডাকার শব্দ সবচেয়ে বেশি?",
            hintEn = "Be gentle when naming them!",
            hintBn = "হেসে খেলে বলো!"
        ),
        PromptItem(
            id = "fam_f_d_1",
            type = PromptType.DARE,
            category = GameCategory.FAMILY,
            intensity = Intensity.FUN,
            textEn = "Speak only in funny questions for the next 2 minutes. Every sentence must end with 'Right?' or 'No?'",
            textBn = "পরবর্তী ২ মিনিট শুধু প্রশ্নবোধক বাক্যে কথা বলো। প্রতিটি কথার শেষে 'তাই না?' থাকতে হবে।",
            hintEn = "Keep the questions coming!",
            hintBn = "প্রশ্ন করেই যাও!"
        ),
        PromptItem(
            id = "fam_f_d_2",
            type = PromptType.DARE,
            category = GameCategory.FAMILY,
            intensity = Intensity.FUN,
            textEn = "Act out a famous cartoon character silently using only charades until someone in the family guesses.",
            textBn = "কোনো কথা না বলে অভিনয়ের মাধ্যমে প্রিয় কার্টুন চরিত্র ফুটিয়ে তোলো যতক্ষণ না কেউ চিনে ফেলে।",
            hintEn = "Tom & Jerry, Mickey, or Shinchan!",
            hintBn = "টম অ্যান্ড জেরি বা মিকি মাউস!"
        ),

        // ==========================================
        // FAMILY - SPICY (PLAYFUL CHALLENGES)
        // ==========================================
        PromptItem(
            id = "fam_s_t_1",
            type = PromptType.TRUTH,
            category = GameCategory.FAMILY,
            intensity = Intensity.SPICY,
            textEn = "What is something you accidentally broke or spilled at home and blamed on a pet or someone else?",
            textBn = "ঘরের কোন জিনিসটা তুমি ভেঙে বা নষ্ট করে অন্য কারও বা পোষা প্রাণীর ঘাড়ে দোষ চাপিয়েছিলে?",
            hintEn = "Time for the family confession!",
            hintBn = "এবার স্বীকার করে নাও!"
        ),
        PromptItem(
            id = "fam_s_t_2",
            type = PromptType.TRUTH,
            category = GameCategory.FAMILY,
            intensity = Intensity.SPICY,
            textEn = "Who in this family spends the most unnecessary amount of time in front of the mirror or screen?",
            textBn = "পরিবারে কে আয়না বা ফোনের স্ক্রিনের সামনে সবচেয়ে বেশি অপ্রয়োজনীয় সময় কাটায়?",
            hintEn = "Nominate with love!",
            hintBn = "ভালোবেসে নাম বলো!"
        ),
        PromptItem(
            id = "fam_s_d_1",
            type = PromptType.DARE,
            category = GameCategory.FAMILY,
            intensity = Intensity.SPICY,
            textEn = "Let the youngest person in the room give you a funny new hairstyle using hair clips or combs.",
            textBn = "ঘরের সবচেয়ে ছোট সদস্যকে তোমার চুলে ক্লিপ বা চিরুনি দিয়ে একটি মজার হেয়ারস্টাইল বানাতে দাও।",
            hintEn = "Show off your new look proudly!",
            hintBn = "নতুন লুক সবাইকে দেখাও!"
        ),
        PromptItem(
            id = "fam_s_d_2",
            type = PromptType.DARE,
            category = GameCategory.FAMILY,
            intensity = Intensity.SPICY,
            textEn = "Sing the chorus of your parents' favorite retro song like an enthusiastic pop star.",
            textBn = "বাবা-মায়ের প্রিয় পুরোনো দিনের কোনো গানের কোরাস একজন পপ তারকার মতো উদ্যম নিয়ে গাও।",
            hintEn = "Go all out!",
            hintBn = "পুরো জোশ নিয়ে গাও!"
        )
    )

    fun filterPrompts(
        type: PromptType?,
        category: GameCategory,
        intensity: Intensity
    ): List<PromptItem> {
        return prompts.filter { item ->
            val typeMatches = (type == null || item.type == type)
            val categoryMatches = (item.category == category)
            val intensityMatches = (item.intensity == intensity)
            typeMatches && categoryMatches && intensityMatches
        }.ifEmpty {
            // Fallback if specific filter combo is sparse
            prompts.filter { it.category == category }
        }
    }
}
