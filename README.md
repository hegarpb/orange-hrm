# Proyek Selenium OrangeHRM

Proyek ini adalah kerangka kerja pengujian otomatisasi untuk aplikasi OrangeHRM. Dibangun menggunakan Java dan memanfaatkan alat pengujian populer untuk memastikan kualitas dan stabilitas aplikasi.

## Jenis Pengujian

Proyek ini menggunakan pendekatan pengujian yang berlapis:

*   **Behavior-Driven Development (BDD) dengan Cucumber:** File fitur yang ditulis dalam sintaks Gherkin (`.feature` files) menjelaskan perilaku yang diharapkan dari aplikasi dari sudut pandang pengguna. Fitur-fitur ini kemudian diotomatisasi menggunakan definisi langkah (step definitions) yang ditulis dalam Java. Ini memastikan bahwa pengujian selaras dengan persyaratan bisnis dan mudah dipahami oleh pemangku kepentingan non-teknis.
*   **Pengujian Unit dan Integrasi:** Meskipun fokus utamanya adalah pada skenario end-to-end melalui BDD, kode Java yang mendasarinya terstruktur untuk mendukung pengujian unit dan integrasi, kemungkinan menggunakan kerangka kerja seperti JUnit atau TestNG, untuk memverifikasi komponen individu dan interaksinya.

## Alat yang Digunakan

Alat dan teknologi berikut merupakan bagian integral dari proyek ini:

*   **Java:** Bahasa pemrograman utama untuk menulis skrip pengujian dan definisi langkah.
*   **Cucumber:** Kerangka kerja BDD yang memungkinkan penulisan pengujian dalam format yang mudah dibaca manusia (Gherkin) dan menjalankannya terhadap kode Java.
*   **Selenium WebDriver:** Pustaka otomatisasi inti yang digunakan untuk berinteraksi dengan peramban web dan mensimulasikan tindakan pengguna pada aplikasi OrangeHRM.
*   **Maven:** Alat otomatisasi build dan manajemen dependensi yang digunakan untuk mengelola dependensi proyek, mengkompilasi kode, dan menjalankan pengujian.
*   **JUnit/TestNG (Kemungkinan):** Kerangka kerja pengujian untuk Java, umumnya digunakan bersama dengan Selenium dan Cucumber untuk eksekusi pengujian, pernyataan (assertions), dan manajemen pengujian. (Kerangka kerja spesifik dapat disimpulkan dari `src/test/java/com/orange/hrm/runners/Runner.java` dan `src/test/resources/suites/main.xml`).
