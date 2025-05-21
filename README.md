# IFSC Code Finder App (Android)

An Android app that allows users to fetch bank details using the IFSC code. This app uses the [Razorpay IFSC API](https://ifsc.razorpay.com/) to retrieve real-time data and display information such as bank name, branch, address, contact number, and available services (NEFT, RTGS, IMPS).

---

## 📱 Screenshots

| Input IFSC Code | Bank Details View |
|-----------------|-------------------|
| ![Input](![image](https://github.com/user-attachments/assets/a960df56-e3ba-4ced-ba18-afe72995f2c4)
) | ![Result](![image](https://github.com/user-attachments/assets/bab8db7b-5f08-44f5-9669-9ba07358d28c)
) |

---

## ✨ Features

- 🔍 Enter any valid Indian IFSC code to fetch bank details.
- 📄 Displays bank name, branch, address, contact, and location.
- ✅ Indicates availability of NEFT, RTGS, and IMPS services.
- 📦 Clean Material Design with ConstraintLayout and CardView.
- 📶 Uses Razorpay’s IFSC API (no API key required).
- 🌓 Light theme support with elegant UI.
- 🛠 Built using Kotlin and Jetpack components.

---

## 🚀 How to Use

1. Clone or download this repository.
2. Open it in **Android Studio**.
3. Make sure you're connected to the internet (for API call).
4. Run the app on an emulator or real device.
5. Type a valid IFSC code (e.g., `HDFC0000123`) and tap **Get Bank Info**.

---

## 🔧 Tech Stack

- **Language**: Kotlin
- **UI**: XML, ConstraintLayout, Material Components
- **Networking**: `HttpURLConnection` / `OkHttp` / `Retrofit` *(based on implementation)*
- **API**: [Razorpay IFSC API](https://ifsc.razorpay.com/)
- **Min SDK**: 21

---

## 📁 Project Structure

app/
├── java/
│ └── com.example.ifscfinder/
│ ├── MainActivity.kt
│ └── utils/
│ └── ApiFetcher.kt
├── res/
│ ├── layout/
│ │ └── activity_main.xml
│ ├── drawable/
│ ├── values/
│ └── colors.xml, strings.xml
└── AndroidManifest.xml


---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Developed By

**Jitendra Kumar**  
MCA Graduate | Android Developer  
[GitHub](https://github.com/jitendrakumar07) | [LinkedIn](https://www.linkedin.com/in/jitendrakumar77/)

---

## 📝 Disclaimer

This app fetches data from Razorpay’s IFSC API. The bank information is for **informational purposes only**. Always verify with your bank before any financial transaction.
