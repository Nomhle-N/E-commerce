<<<<<<< HEAD
# IncredibleTech

### IncredibleTech is an e-commerce platform born right in the IT labs of CPUT District Six. We skipped the corporate middleman to bring reliable, high-quality pre-built laptops and electronics directly to everyday South Africans at a price that won't break the bank. No tech-jargon, no massive markups just great deals and fast local delivery.
=======
# E-commerce
>>>>>>> b79fd96 (Initial commit)

## Group Members

* **Member 1**: TIYANI NGWANA 231266731 - Payment Entity
* **Member 2**: ABULELE NTWANAMBI 218276400 - Feedback Entity
* **Member 3**: NOMHLE NJENGELE 216227488 - ProductCatalog Entity
* **Member 4**: OWENKOSI NXASANA 230240887 - UserManagement Entity
* **Member 5**: SINAZO NTSIMBI 222765208 - Delivery Entity
* **Member 6**: SINETHEMBA NYIMBINYA 220085870 - Order Entity

## Entities

* **UserManagement**:This handles the people using the system. It keeps track of the differences between customers (who buy things) and administrators (staff members who manage the store).
* **ProductCatalog**:This is the store's inventory. It manages the lists of individual computer parts (like graphics cards or processors) and full, ready-to-use desktop computers that are for sale.
* **Order**:This handles the checkout process. When a customer buys things, this creates a main receipt that lists every single item they purchased and tracks the overall status of the purchase.
* **Payment**:It safely records and processes the financial transactions when a customer pays using credit cards or digital wallets.
* **Delivery**: Logistics tracking, airway bills, and geographic transport milestones.
* **Feedback**: Customer-submitted product reviews and delivery service rating matrices.

## Contributing Guidelines

### Pull Request Process

1. Create a development branch named explicitly with your student number.
2. Implement your vertical layer feature completely alongside corresponding Test-Driven Development (TDD) fixtures.
3. Execute localized compilation to ensure all engineering tests pass successfully.
4. Update class-level documentation if additional properties are added to standard models.
5. Open a formal Pull Request (PR) directing your branch into the `main` trunk.
6. Request an architectural review validation from the team lead before merging.
7. Address any code quality review comments promptly.
8. Merge securely into `main` after receiving official approval.

### Code Review Checklist

* [ ] **Follows Builder Pattern**: Completely hand-coded without any external framework extensions.
* [ ] **Strict Immutability**: Contains public accessors but **zero setter methods**.
* [ ] **Validation Failure Logic**: Intentionally returns `null` instead of throwing execution exceptions when invariants fail.
* [ ] **Includes TDD Tests**: Validates functional parameters using clean JUnit 5 text runners.
* [ ] **Proper Package Placement**: Strictly fits root package domains (`domain`, `factory`, `repository`, `service`, `controller`, % `helper`).
* [ ] **Author Comments Included**: Structured file header metadata block visible at the absolute top of the source code file.
* [ ] **No Merge Conflicts**: Branch line matches cleanly with upstream components.
* [ ] **All Tests Are Passing**

## UML Diagram

<img width="1536" height="1024" alt="final uml" src="https://github.com/user-attachments/assets/eda6382a-5bf6-4091-8384-1de4554c8981" />

