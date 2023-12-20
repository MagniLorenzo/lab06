# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
> git status
Sul branch master
Il tuo branch è aggiornato rispetto a 'origin/master'.

non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito

2. Ci si assicuri di avere localmente entrambi i branch remoti
> git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
> git checkout -b feature origin/feature
Branch 'feature' impostato per tracciare il branch remoto 'feature' da 'origin'.
Si è passati a un nuovo branch 'feature'
> git status
Sul branch feature
Il tuo branch è aggiornato rispetto a 'origin/feature'.

non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito
> git checkout master
Si è passati al branch 'master'
Il tuo branch è aggiornato rispetto a 'origin/master'.
> git status
Sul branch master
Il tuo branch è aggiornato rispetto a 'origin/master'.

non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito
> git merge feature
Merge automatico di HelloWorld.java in corso
CONFLITTO (contenuto): conflitto di merge in HelloWorld.java
Merge automatico fallito; risolvi i conflitti ed esegui il commit
del risultato.
> git status
Sul branch master
Il tuo branch è aggiornato rispetto a 'origin/master'.

Hai dei percorsi non sottoposti a merge.
  (risolvi i conflitti ed esegui "git commit")
  (usa "git merge --abort" per interrompere il merge)

Percorsi non sottoposti a merge:
  (usa "git add <file>..." per contrassegnare il conflitto come risolto)
	entrambi modificati: HelloWorld.java

nessuna modifica aggiunta al commit (usa "git add" e/o "git commit -a")


4. Si noti che viene generato un **merge conflict**!

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
> git add HelloWorld.java
> git status
Sul branch master
Il tuo branch è aggiornato rispetto a 'origin/master'.

Tutti i conflitti sono stati risolti ma il merge è ancora in corso.
  (usa "git commit" per terminare il merge)

Modifiche di cui verrà eseguito il commit:
	modificato:             HelloWorld.java
> git commit -m 'Risolto merge conflict'
[master bbdeb02] Risolto merge conflict
> git status
Sul branch master
Il tuo branch è avanti rispetto a 'origin/master' di 2 commit.
  (usa "git push" per pubblicare i tuoi commit locali)

non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito

6. Si crei un nuovo repository nel proprio github personale

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
> git remote add personal-repo git@github.com:MagniLorenzo/OOP-merge-conflict-test.git
> git remote -v
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (push)
personal-repo	git@github.com:MagniLorenzo/OOP-merge-conflict-test.git (fetch)
personal-repo	git@github.com:MagniLorenzo/OOP-merge-conflict-test.git (push)

8. Si faccia push del branch `master` sul proprio repository
> git push personal-repo master
Enumerazione degli oggetti in corso: 15, fatto.
Conteggio degli oggetti in corso: 100% (15/15), fatto.
Compressione delta in corso, uso fino a 8 thread
Compressione oggetti in corso: 100% (11/11), fatto.
Scrittura degli oggetti in corso: 100% (15/15), 1.56 KiB | 1.56 MiB/s, fatto.
15 oggetti totali (4 delta), 10 riutilizzati (2 delta), 0 riutilizzati nel file pack
remote: Resolving deltas: 100% (4/4), done.
To github.com:MagniLorenzo/OOP-merge-conflict-test.git
 * [new branch]      master -> master
> git status
Sul branch master
Il tuo branch è avanti rispetto a 'origin/master' di 2 commit.
  (usa "git push" per pubblicare i tuoi commit locali)

non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
> git branch --set-upstream-to=personal-repo/master
Branch 'master' impostato per tracciare il branch remoto 'master' da 'personal-repo'.
> git status
Sul branch master
Il tuo branch è aggiornato rispetto a 'personal-repo/master'.

non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito

