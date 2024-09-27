# EnDcypt: Encryption-Decryption Service

## 1. **Project Overview**

This Java-based Encryption-Decryption Service allows users to dynamically select and apply different encryption algorithms (AES, DES, Caesar Cipher) to encrypt and decrypt text files. 

## 2. **Project Structure**

The project is organized into packages for algorithms and core management, with a main class handling user interactions.

### Directory Structure:
```
encryption_service/
│
├── algorithms/
│   ├── EncryptionAlgorithm.java
│   ├── AES.java
│   ├── DES.java
│   └── CaesarCipher.java
│
├── EncryptionManager.java
└── Main.java
```

## 3. **Core Components**

### 3.1. **Algorithms**
- **EncryptionAlgorithm**: Interface defining `encrypt` and `decrypt` methods.
- **AES**: Implements AES encryption and decryption.
- **DES**: Implements DES encryption and decryption.
- **CaesarCipher**: Implements Caesar Cipher with a configurable shift value.

### 3.2. **EncryptionManager**
Manages the selection of the encryption algorithm based on user input and handles the encryption and decryption processes.

### 3.3. **Main**
Handles user interaction, allowing selection of the encryption method, input of file names, and displays encrypted and decrypted results.

## 4. **Design Patterns**

1. **Strategy Pattern**: Enables dynamic selection of encryption algorithms at runtime, promoting flexibility and ease of extension.
2. **Factory Pattern** (implicitly via `selectAlgorithm` method): Facilitates the creation of algorithm instances based on user choice.

## 5. **Usage**

1. **Select Algorithm**: Choose between AES, DES, or Caesar Cipher.
2. **Provide Parameters**: If Caesar Cipher is selected, specify the shift value.
3. **Input File**: Enter the name of the text file to encrypt.
4. **Process**: The system encrypts the file content and saves it to a new file, then decrypts it for validation.

Thank You!