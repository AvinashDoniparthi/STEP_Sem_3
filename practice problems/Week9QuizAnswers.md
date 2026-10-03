# Week 9 Polymorphism Quiz Answers

## Multiple Choice

1. C — Polymorphism dispatches to each document type's `render()` implementation.
2. A, B, C — Each is an `is-a` relationship; D describes composition.
3. C — Runtime method dispatch selects the implementation for the object's actual type.
4. C — The shape subclasses demonstrate inheritance-based polymorphism.
5. A, C, D — `Book` extends or overrides behavior, the base class defines common behavior, and a `DVD` can be used as a `LibraryItem`.
6. A, C — An `Animal` reference dispatches to `Dog.makeSound()`, and the dog method overrides the base method.
7. C — A new payment subtype can be added without changing the processor's polymorphic loop.
8. A — Reuse without an `is-a` relationship creates tight coupling and a misleading, rigid design.
9. A, C — A generic sender can handle every subtype, and new channels can be added without changing that sender.
10. A, B, C — Polymorphic collections allow uniform processing and avoid type checks and casts.

## Concept Questions

1. Inheritance lets a specialized type keep shared state and behavior from a base type while adding or overriding what differs. For example, `SavingsAccount` can reuse balance operations from `BankAccount` and add an interest calculation.
2. An `is-a` relationship means every instance of the derived type can be used where the base type is expected. A `Car` is a `Vehicle`, so `Car` can inherit from `Vehicle`; correct relationships keep substitutions meaningful and prevent invalid operations from being inherited.
3. Method overriding is a derived class's replacement implementation of an inherited instance method with the same signature. For example, `SalariedEmployee.calculatePay()` can return a fixed salary while `HourlyEmployee.calculatePay()` multiplies hours by an hourly rate.
4. Runtime polymorphism chooses an overridden method using the object's actual class, not the declared type of its reference. A `Vehicle` reference holding a `Car` calls `Car`'s override when `start()` is invoked.
5. A polymorphic collection stores different derived instances through one base type, such as `List<Notification>` containing email, SMS, and push notifications. A common loop can invoke `send()` on each without branching on concrete classes.
6. With polymorphism, each type owns its behavior behind a common method; repeated type checks centralize branching and must be edited whenever a new type is added. Overriding keeps the processing loop stable and makes additions easier to maintain.
7. A new derived type can implement or override the base contract and join existing processing. For example, `WalletPayment` can implement `calculateFee()` and be added to a `List<Payment>` without changing the payment processor's loop.
8. Inherited behavior is used unchanged when it already fits, such as every employee inheriting `getName()`. Overridden behavior replaces or specializes a method when a subtype differs, such as `HourlyEmployee.calculatePay()`.
9. Inheritance without a genuine `is-a` relationship promises substitutability that is not true. It couples unrelated classes, exposes inappropriate behavior, and makes future changes more fragile; composition is usually the better reuse mechanism.
10. `CarRental` and `TruckRental` can inherit shared customer, duration, and base-cost behavior from `VehicleRental`. Each subtype can override its rate calculation and add specific rules, such as truck mileage limits, while a rental service processes both through the common type.