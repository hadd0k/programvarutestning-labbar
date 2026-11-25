# ETSN20 Lab 3: Debugging

Ingen skriftlig rapport – resultaten redovisas muntligt. Anteckningar nedan är underlag för redovisningen.

**Projekt (Maven, körs i VS Code i stället för Eclipse):**
- `Lab3/DebugIntro` – `fact.java`, `fib.java`, `InsertionSorter.java`
- `Lab3/DebugReqSimili` – ReqSimile (större kodbas, bra att köra SpotBugs på)

**VS Code-setup:** öppna repo-roten i VS Code (Extension Pack for Java krävs). Maven-projekten importeras automatiskt.
- Debugga: *Run and Debug* (Ctrl+Shift+D) → välj t.ex. `Lab3: fact (5)` → F5. Konfigurationer finns i `.vscode/launch.json`.
- SpotBugs: *Terminal → Run Task…* → `Lab3: SpotBugs …` (eller `mvn compile spotbugs:check` / `spotbugs:gui` i projektmappen).

**Eclipse → VS Code:**

| Eclipse | VS Code |
|---|---|
| Toggle breakpoint (dubbelklick i marginalen) | F9 / klick i marginalen |
| Resume F8 | Continue F5 |
| Step Over F6 | Step Over F10 |
| Step Into F5 | Step Into F11 |
| Step Return F7 | Step Out Shift+F11 |
| Breakpoint Properties → Conditional | Högerklick på breakpoint → *Edit Condition* (även *Hit Count* och *Logpoint*) |
| Variables-vyn, Change Value | Variables-panelen → högerklick → *Set Value* (eller F2) |
| Expressions-vyn | Watch-panelen (+) / Debug Console för att utvärdera uttryck |
| Debug-vyn, call stack | Call Stack-panelen |
| Drop To Frame | Call Stack → högerklick → *Restart Frame* |
| SpotBugs-plugin | `spotbugs-maven-plugin` (se ovan) |

*Not:* `DriverShim.java` i ReqSimile har fått metoden `getParentLogger()` för att koden (skriven för Java 1.6) ska kompilera på moderna JDK – det är inte en av labbens buggar.

---

## 3 Preparation

### Assignment 1
Read:
a) Chapter 1 in *The Art of Debugging with GDB, DDD, and Eclipse* (Matloff & Salzman)
b) Section 3.6 in *Software Testing and Quality Assurance: Theory and Practice* (Naik & Tripathy)
c) The related slides from the lecture

> **Svar:**
>


### Assignment 2
Search the web for lists of bugs that are considered the most frequent in Java. Compare this to your own experience. Do you agree? Have frequent bug patterns in mind when you come to the lab.

> **Svar:**
>


### Assignment 3
Search and install SpotBugs on Eclipse Marketplace. Look briefly at the quick plugin introduction. Explore the bug descriptions in the SpotBugs documentation (https://spotbugs.readthedocs.io/).
- *(VS Code: SpotBugs körs via Maven-pluginet i stället – redan konfigurerat i båda `pom.xml`.)*

> **Svar:**
>


---

## 4 During the lab session

### Assignment 4 – Exploring basic debugger functionality
Work with `fact.java` in the Debug perspective *(VS Code: Run and Debug-vyn, konfiguration `Lab3: fact (5)`)*. Toggle a breakpoint on the very first statement of `main`. Run in Debug mode with argument e.g. `5`. Make sure you try out and understand at least:

a) Different ways of stepping. Learn the short keys for Resume, Step Into and Step Over.

> **Svar:**
>

b) Breakpoints. Toggle/enable/disable/delete.

> **Svar:**
>

c) Conditional breakpoints (right-click an existing breakpoint).

> **Svar:**
>

d) Monitoring variables. Change the value of a variable in a running program. Add watches to the Expressions view.

> **Svar:**
>

e) The call stack in the Debug view. Right-click a stack level and select "Drop To Frame". (Variable values are not reset!)

> **Svar:**
>


### Assignment 5 – Hunt the first bug
`fib.java` should recursively calculate Fibonacci numbers but produces no output.
F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2). Use the debugger to find out why there is no output and correct the error.

> **Svar:**
>
> - Symptom:
> - Hur felet hittades i debuggern:
> - Orsak:
> - Rättning:


### Assignment 6 – Less obvious bugs
Debug `InsertionSorter`. Apply the binary search approach to localize the defect(s) and correct them. Debug the existing implementation – don't replace it.

| | |
|---|---|
| Input | `12 5 9 3 2 25 8 19 200 10` |
| Expected | `2 3 5 8 9 10 12 19 25 200` |
| Actual | `10 0 0 0 0 0 0 0 0 0` |

> **Svar:**
>
> | # | Plats (metod/rad) | Fel | Hur det hittades | Rättning |
> |---|---|---|---|---|
> | 1 | | | | |
> | 2 | | | | |
> | 3 | | | | |


### Assignment 7 – Use GenAI for debugging
Prompt your favourite generative AI tool to assist in the analysis of assignments 5 and 6. What type of guidance did you get? How valid was it in your debugging process?

> **Svar:**
>


### Assignment 8 – Bug reporting process in an OSS community
Explore the JabRef project (https://github.com/JabRef/jabref).

a) Which role does one need to have to be able to report a bug for the project?

> **Svar:**
>

b) Can anyone commit source code into the repository (e.g. a bug fix), or does one need a special role, and if so which? Who accepts the code/pull request/contribution?

> **Svar:**
>

c) Given the different roles, briefly explain the concept of meritocracy for the roles.

> **Svar:**
>

d) Which communication channels are used in this project?

> **Svar:**
>

Read the contribution guidelines and look at "Good first issue" issues:

e) What kind of information are you provided with about the task? Is the task well documented and are necessary resources specified? Justify your answer.

> **Svar:**
>

f) Do you see any benefits in taking an active role in an OSS project? Justify your answer.

> **Svar:**
>


---

## 6 Examination
Typical exam question: compare ordinary printouts and debuggers.

> **Anteckningar:**
>
