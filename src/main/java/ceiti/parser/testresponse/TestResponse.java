package ceiti.parser.testresponse;

public class TestResponse {
    public static final String response = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Date student</title>
            <meta name="description" content="">
            <meta name="author" content="">
            <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
            <link href="/assets/css/style.css" rel="stylesheet">
            <link href="/assets/css/datatables.min.css" rel="stylesheet">
            <script src="/assets/js/jquery.min.js"></script>
            <script src="/assets/js/datatables.min.js"></script>
            <script async src='/cdn-cgi/challenge-platform/h/g/scripts/invisible.js?ts=1650574800'></script></head>
            <body>
            <div class="container-fluid">
            <div class="row">
            <div class="col-lg-12">
            <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active">
            <a href="#date-personale" aria-controls="date-personale" role="tab" data-toggle="tab">
            Date personale
            </a>
            </li>
            <li role="presentation">
            <a href="#situatia-curenta" aria-controls="situatia-curenta" role="tab" data-toggle="tab">
            Situația curentă
            </a>
            </li>
            <li role="presentation">
            <a href="#note-1" aria-controls="note-1" role="tab" data-toggle="tab">
            Teze / Examene / Practică
            </a>
            </li>
            <li role="presentation">
            <a href="#note-2" aria-controls="note-2" role="tab" data-toggle="tab">
            Notele semestriale și anuale
            </a>
            </li>
            <li role="presentation">
            <a href="#note-3" aria-controls="note-3" role="tab" data-toggle="tab">
            Note BAC
            </a>
            </li>
            <li role="presentation">
            <a href="#taxe-1" aria-controls="taxe-1" role="tab" data-toggle="tab">
            Taxe achitate
            </a>
            </li>
            <li role="presentation">
            <a href="#taxe-2" aria-controls="taxe-2" role="tab" data-toggle="tab">
            Taxe spre achitare
            </a>
            </li>
            </ul>
            </div>
            <div class="col-lg-8">
            <div class="tab-content" style="padding-top: 20px;">
            <div role="tabpanel" class="tab-pane active" id="date-personale">
            <table class="table table-bordered table-condensed table-hover table-white">
            <tr>
            <th>Numele</th>
            <td>Dubrovschii</td>
            </tr>
            <tr>
            <th>Prenumele</th>
            <td>Semion</td>
            </tr>
            <tr>
            <th>Patronimicul</th>
            <td>Iuri</td>
            </tr>
            <tr>
            <th>Anul de studii</th>
            <td>II</td>
            </tr>
            <tr>
            <th>Grupa</th>
            <td>P-2023r</td>
            </tr>
            <tr>
            <th>Specialitatea</th>
            <td>Programarea și analiza produselor de program, RO</td>
            </tr>
            <tr>
            <th>Diriginte</th>
            <td>Guseinov Tamara</td>
            </tr>
            <tr>
            <th>Șef secție</th>
            <td>Pasecinic Irina</td>
            </tr>
            <tr>
            <th>Statut</th>
            <td>Înmatriculat</td>
            </tr>
            </table>
            </div>
            <div role="tabpanel" class="tab-pane" id="situatia-curenta">
            <div class="panel-group" id="accordion3" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headin3g1">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion3" href="#collaps3e1" aria-expanded="true" aria-controls="collaps3e1" class="">
            Semestrul I
            </a>
            </h4>
            </div>
            <div id="collaps3e1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headin3g1">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumire
            </th>
            <th>
            Note
            </th>
            </tr>
            <tr>
            <td>
            <p>Asistenţă pentru baze de date</p>
            </td>
            <td>
            <p>9, 9, 8, 9, 9, 7, 9, 9, 7, 10, 9</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Biologia</p>
            </td>
            <td>
            <p>8, 9, 9, 8, 9</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Decizii pentru modul sănătos de viață</p>
            </td>
            <td>
            <p>9, 9, 9, 9, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educaţia fizică</p>
            </td>
            <td>
            <p>b</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educația pentru societate</p>
            </td>
            <td>
             <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Geografia</p>
            </td>
            <td>
            <p>10, 10, 9</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Informatica</p>
            </td>
            <td>
            <p>10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Istoria</p>
            </td>
            <td>
            <p>10, 10, 9</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba Străină</p>
            </td>
            <td>
            <p>8, 10, 9, 9, 9, 9, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura romană</p>
            </td>
            <td>
            <p>b, 10, 8, 9, 10, 10, 10, 9, a, 9, 9</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura rusă</p>
            </td>
            <td>
            <p>9, 9, 9, 9, 9, 9, 10, 8, 10, 9</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Matematica</p>
            </td>
            <td>
            <p>10, 10, 10, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Procesarea Imaginilor</p>
            </td>
            <td>
             <p>7, 8, 10, 10, 9, 8</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Programarea calculatoarelor</p>
            </td>
            <td>
            <p>10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 10, 10, 10, 10, 9</p>
            </td>
            </tr>
            <tr>
            <th>Absențe totale</th>
            <th>4 </th>
            </tr>
            <tr>
            <td><i>Bolnav</i></td>
            <td><i>2</i></td>
            </tr>
            <tr>
            <td><i>Motivate</i></td>
            <td><i>2</i></td>
            </tr>
            <tr>
            <td><i>Nemotivate</i></td>
            <td><i>2</i></td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="headin3g2">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion3" href="#collaps3e2" aria-expanded="false" aria-controls="collaps3e2" class="collapsed">
            Semestrul II
            </a>
            </h4>
            </div>
            <div id="collaps3e2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headin3g2">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Semestrul II
            </th>
            <th>
            Note
            </th>
            </tr>
            <tr>
            <td>
            <p>Asistenţă pentru POO</p>
            </td>
            <td>
            <p>10, 10, 10, 10, 9, 9, 10, 9, 9, 10, 10, 9, 10, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Biologia</p>
             </td>
            <td>
            <p>9, 10, 9</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educaţia fizică</p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educația pentru societate</p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Geografia</p>
            </td>
            <td>
            <p>9, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Implementarea limbajului SQL</p>
            </td>
            <td>
            <p>10, 9, 9, 10, 10, 9, 9, 10, 10, 10, 10, 10, 8, 9, a, a, a, 10, 9</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Informatica</p>
            </td>
            <td>
            <p>10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Istoria</p>
            </td>
            <td>
            <p>10, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba Străină</p>
            </td>
            <td>
            <p>10, 10, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura romană</p>
            </td>
             <td>
            <p>10, 10, 9, 10, 9, 9, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura rusă</p>
            </td>
            <td>
            <p>9, 9, 9, 9, 8, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Matematica</p>
            </td>
            <td>
            <p>10, 10, 10, 10, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Procesarea Imaginilor</p>
            </td>
            <td>
            <p>a, 9, 10, 10, 9, a, 10, 10</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Tehnici de comunicare</p>
            </td>
            <td>
            <p>10, 10, 10, 10</p>
            </td>
            </tr>
            <tr>
            <th>Absențe totale</th>
            <th>10 </th>
            </tr>
            <tr>
            <td><i>Bolnav</i></td>
            <td><i>0</i></td>
            </tr>
            <tr>
            <td><i>Motivate</i></td>
            <td><i>0</i></td>
            </tr>
            <tr>
            <td><i>Nemotivate</i></td>
            <td><i>10</i></td>
            </tr>
            </table>
            </div>
            </div>
            </div>
            </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="note-1">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="heading0">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse0" aria-expanded="true" aria-controls="collapse0" class="=">
            Semestrul 1 </a>
            </h4>
            </div>
            <div id="collapse0" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading0">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota
            </th>
            </tr>
            <tr>
            <td>
            <p>(Examen) Tehnologia informatiei si a comunicatiei</p>
            </td>
            <td>
            <p>8.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Programarea Structurată</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="heading1">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse1" aria-expanded="false" aria-controls="collapse1" class="collapsed">
            Semestrul 2 </a>
            </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse " role="tabpanel" aria-labelledby="heading1">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota
            </th>
            </tr>
            <tr>
            <td>
            <p>(Examen) Structura și funcționarea calculatoarelor</p>
             </td>
            <td>
            <p>9.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Programarea Procedurală</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Practica) Practica de iniţiere în specialitate</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="heading2">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false" aria-controls="collapse2" class="collapsed">
            Semestrul 3 </a>
            </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse " role="tabpanel" aria-labelledby="heading2">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota
            </th>
            </tr>
            <tr>
            <td>
            <p>(Teza) Limba şi literatura romană</p>
            </td>
            <td>
            <p>8.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Teza) Biologia</p>
            </td>
            <td>
            <p>9.00</p>
            </td>
            </tr>
            <tr>
             <td>
            <p>(Examen) Procesarea Imaginilor</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Programarea calculatoarelor</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Asistenţă pentru baze de date</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Decizii pentru modul sănătos de viață</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Teza) Informatica</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="heading3">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false" aria-controls="collapse3" class="collapsed">
            Semestrul 4 </a>
            </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse " role="tabpanel" aria-labelledby="heading3">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota
            </th>
             </tr>
            <tr>
            <td>
            <p>(Examen) Procesarea Imaginilor</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Tehnici de comunicare</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Asistenţă pentru POO</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Implementarea limbajului SQL</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Practica) Instructivă</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Teza) Limba Străină</p>
            </td>
            <td>
            <p>8.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Teza) Istoria</p>
            </td>
            <td>
            <p>9.00</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Teza) Matematica</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            </tr>
             </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="heading4">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse4" aria-expanded="false" aria-controls="collapse4" class="collapsed">
            Semestrul 5 </a>
            </h4>
            </div>
            <div id="collapse4" class="panel-collapse collapse " role="tabpanel" aria-labelledby="heading4">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota
            </th>
            </tr>
            <tr>
            <td>
            <p>(Examen) Protecţia consumatorului</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Bazele legislației în domeniu</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Sisteme de gestiune a bazelor de date</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Bazele managementului şi marketingului</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Utilizarea tehnicilor clasice de programare</p>
            </td>
            <td>
             <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Utilizarea metodelor și modelelor economico-matematice</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="heading5">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse5" aria-expanded="false" aria-controls="collapse5" class="collapsed">
            Semestrul 6 </a>
            </h4>
            </div>
            <div id="collapse5" class="panel-collapse collapse " role="tabpanel" aria-labelledby="heading5">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota
            </th>
            </tr>
            <tr>
            <td>
            <p>(Examen) Filosofia</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Protecţia civilă</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Psihologia social-economică</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Asistență pentru programarea vizuală</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Asistență pentru crearea site-urilor Web</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Practica) Tehnologică</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="heading6">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse6" aria-expanded="false" aria-controls="collapse6" class="collapsed">
            Semestrul 7 </a>
            </h4>
            </div>
            <div id="collapse6" class="panel-collapse collapse " role="tabpanel" aria-labelledby="heading6">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota
            </th>
            </tr>
            <tr>
            <td>
            <p>(Examen) Bazele antreprenoriatului</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Tehnologii avansate de programare</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
             <tr>
            <td>
            <p>(Examen) Securitatea și sănătatea în muncă</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Administrarea reţelelor de calculatoare</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Asistență pentru prog. site-urilor Web</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Asistența în securitatea informațională</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Utilizarea sistemelor de operare în rețea</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Limba străină aplicată în domeniul TIC I</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Utilizarea algoritmilor de criptare a informației</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Utilizarea sistemelor de operare pentru dispozitive mobile</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="heading7">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse7" aria-expanded="false" aria-controls="collapse7" class="collapsed">
            Semestrul 8 </a>
            </h4>
            </div>
            <div id="collapse7" class="panel-collapse collapse " role="tabpanel" aria-labelledby="heading7">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota
            </th>
            </tr>
            <tr>
            <td>
            <p>(Examen) Etica profesională</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Testarea funcţională</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Dezvoltarea paginilor Web</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Promovarea produselor software</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Dezvoltarea aplicațiilor desktop</p>
             </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Testarea şi depănarea produselor program</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Limba străină aplicată în domeniul TIC II </p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Asistență în managementul proiectelor software</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Utilizarea instrumentelor software pentru afaceri</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Examen) Dezvoltarea aplicațiilor pentru dispozitive mobile</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>(Practica) Practica ce anticipează probele de absolvire</p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            </div>
            </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="note-2">
            <div class="panel-group" id="accordion2" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headin2g0">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion2" href="#collaps2e0" aria-expanded="true" aria-controls="collaps2e0" class="=">
            Anul 1 </a>
            </h4>
            </div>
            <div id="collaps2e0" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headin2g0">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota semestru I
            </th>
            <th>
            Nota semestru II
            </th>
            <th>
            Nota anuala
            </th>
            <th>
            Nota evaluare
            </th>
            <th>
            Tip evaluare
            </th>
            </tr>
            <tr>
            <td>
            <p>Structura și funcționarea calculatoarelor</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>8.92</p>
            </td>
            <td>
            <p>8.92</p>
            </td>
            <td>
            <p>9</p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Programarea Procedurală</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>9.91</p>
            </td>
            <td>
            <p>9.91</p>
            </td>
            <td>
            <p>10</p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Tehnologia informatiei si a comunicatiei</p>
            </td>
            <td>
            <p>8.42</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>8.42</p>
            </td>
            <td>
            <p>8</p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Programarea Structurată</p>
            </td>
            <td>
            <p>9.79</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>9.79</p>
            </td>
            <td>
            <p>10</p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura rusă</p>
            </td>
            <td>
            <p>8.66</p>
            </td>
            <td>
            <p>8.41</p>
             </td>
            <td>
            <p>8.53</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba Străină</p>
            </td>
            <td>
            <p>8.87</p>
            </td>
            <td>
            <p>8.25</p>
            </td>
            <td>
            <p>8.56</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Istoria</p>
            </td>
            <td>
            <p>9.00</p>
            </td>
            <td>
            <p>8.25</p>
            </td>
            <td>
            <p>8.62</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Geografia</p>
            </td>
            <td>
            <p>8.50</p>
            </td>
            <td>
            <p>8.75</p>
            </td>
            <td>
            <p>8.62</p>
            </td>
            <td>
            <p></p>
             </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Biologia</p>
            </td>
            <td>
            <p>8.83</p>
            </td>
            <td>
            <p>8.80</p>
            </td>
            <td>
            <p>8.81</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura romană</p>
            </td>
            <td>
            <p>9.11</p>
            </td>
            <td>
            <p>8.85</p>
            </td>
            <td>
            <p>8.98</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Chimia</p>
            </td>
            <td>
            <p>9.00</p>
            </td>
            <td>
            <p>9.33</p>
            </td>
            <td>
            <p>9.16</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Matematica</p>
            </td>
            <td>
            <p>9.66</p>
            </td>
            <td>
            <p>9.57</p>
            </td>
            <td>
            <p>9.61</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Informatica</p>
            </td>
            <td>
            <p>9.50</p>
            </td>
            <td>
            <p>9.75</p>
            </td>
            <td>
            <p>9.62</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Fizica/Astronomia</p>
            </td>
            <td>
            <p>9.25</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            <td>
            <p>9.62</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educația pentru societate</p>
            </td>
            <td>
            <p></p>
             </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educaţia fizică</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="headin2g1">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion2" href="#collaps2e1" aria-expanded="false" aria-controls="collaps2e1" class="collapsed">
            Anul 2 </a>
            </h4>
            </div>
            <div id="collaps2e1" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headin2g1">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota semestru I
            </th>
            <th>
            Nota semestru II
            </th>
            <th>
             Nota anuala
            </th>
            <th>
            Nota evaluare
            </th>
            <th>
            Tip evaluare
            </th>
            </tr>
            <tr>
            <td>
            <p>Limba Străină</p>
            </td>
            <td>
            <p>9.25</p>
            </td>
            <td>
            <p>9.00</p>
            </td>
            <td>
            <p>9.12</p>
            </td>
            <td>
            <p>8</p>
            </td>
            <td>
            <p>Teză</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Istoria</p>
            </td>
            <td>
            <p>9.66</p>
            </td>
            <td>
            <p>9.50</p>
            </td>
            <td>
            <p>9.58</p>
            </td>
            <td>
            <p>9</p>
            </td>
            <td>
            <p>Teză</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Informatica</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            <td>
            <p>10</p>
            </td>
            <td>
             <p>Teză</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Matematica</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            <td>
            <p>10.00</p>
            </td>
            <td>
            <p>10</p>
            </td>
            <td>
            <p>Teză</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura romană</p>
            </td>
            <td>
            <p>8.66</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>8.66</p>
            </td>
            <td>
            <p>8</p>
            </td>
            <td>
            <p>Teză</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Biologia</p>
            </td>
            <td>
            <p>8.75</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>8.75</p>
            </td>
            <td>
            <p>9</p>
            </td>
            <td>
            <p>Teză</p>
            </td>
            </tr>
            <tr>
            <td>
             <p>Asistenţă pentru baze de date</p>
            </td>
            <td>
            <p>9.17</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>9.17</p>
            </td>
            <td>
            <p>10</p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Procesarea Imaginilor</p>
            </td>
            <td>
            <p>9.19</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>9.19</p>
            </td>
            <td>
            <p>10</p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Decizii pentru modul sănătos de viață</p>
            </td>
            <td>
            <p>9.52</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>9.52</p>
            </td>
            <td>
            <p>10</p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Programarea calculatoarelor</p>
            </td>
            <td>
            <p>9.92</p>
             </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>9.92</p>
            </td>
            <td>
            <p>10</p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Implementarea limbajului SQL</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>5.70</p>
            </td>
            <td>
            <p>5.70</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura rusă</p>
            </td>
            <td>
            <p>9.10</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>9.10</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Geografia</p>
            </td>
            <td>
            <p>9.66</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
             <p>9.66</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Tehnici de comunicare</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Asistenţă pentru POO</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educația pentru societate</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
             <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educaţia fizică</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="headin2g2">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion2" href="#collaps2e2" aria-expanded="false" aria-controls="collaps2e2" class="collapsed">
            Anul 3 </a>
            </h4>
            </div>
            <div id="collaps2e2" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headin2g2">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota semestru I
            </th>
            <th>
            Nota semestru II
            </th>
            <th>
            Nota anuala
            </th>
            <th>
            Nota evaluare
            </th>
            <th>
            Tip evaluare
            </th>
            </tr>
            <tr>
            <td>
             <p>Bazele legislației în domeniu</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Bazele managementului şi marketingului</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Filosofia</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Protecţia civilă</p>
            </td>
            <td>
            <p></p>
            </td>
             <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Asistență pentru programarea vizuală</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Asistență pentru crearea site-urilor Web</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Protecţia consumatorului</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
             </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Psihologia social-economică</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Sisteme de gestiune a bazelor de date</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Utilizarea tehnicilor clasice de programare</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
             <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Utilizarea metodelor și modelelor economico-matematice</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educaţia civică</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Geografia</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
             <p>Chimia</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Biologia</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Informatica</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Istoria</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Educaţia fizică</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Fizica/Astronomia</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba Străină</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
             </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura rusă</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba şi literatura romană</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Matematica</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            </tr>
             </table>
            </div>
            </div>
            <div class="panel-heading" role="tab" id="headin2g3">
            <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion2" href="#collaps2e3" aria-expanded="false" aria-controls="collaps2e3" class="collapsed">
            Anul 4 </a>
            </h4>
            </div>
            <div id="collaps2e3" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headin2g3">
            <div class="panel-body">
            <table class="table table-bordered table-condensed table-hover">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Nota semestru I
            </th>
            <th>
            Nota semestru II
            </th>
            <th>
            Nota anuala
            </th>
            <th>
            Nota evaluare
            </th>
            <th>
            Tip evaluare
            </th>
            </tr>
            <tr>
            <td>
            <p>Dezvoltarea paginilor Web</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Securitatea și sănătatea în muncă</p>
            </td>
            <td>
             <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Testarea funcţională</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Promovarea produselor software</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Asistența în securitatea informațională</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
             <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Etica profesională</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Utilizarea instrumentelor software pentru afaceri</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Utilizarea algoritmilor de criptare a informației</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
             </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Administrarea reţelelor de calculatoare</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Dezvoltarea aplicațiilor desktop</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Dezvoltarea aplicațiilor pentru dispozitive mobile</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
             </tr>
            <tr>
            <td>
            <p>Limba străină aplicată în domeniul TIC I</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Limba străină aplicată în domeniul TIC II </p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Asistență în managementul proiectelor software</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Utilizarea sistemelor de operare în rețea</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Utilizarea sistemelor de operare pentru dispozitive mobile</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Bazele antreprenoriatului</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Testarea şi depănarea produselor program</p>
            </td>
            <td>
            <p></p>
            </td>
             <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Tehnologii avansate de programare</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            <tr>
            <td>
            <p>Asistență pentru prog. site-urilor Web</p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p></p>
            </td>
            <td>
            <p>Examen</p>
            </td>
            </tr>
            </table>
            </div>
            </div>
            </div>
            </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="note-3">
            <table class="table table-bordered table-condensed table-hover table-white">
            <tr>
            <th>
            Denumirea Obiectelor
            </th>
            <th>
            Tip
            </th>
            <th>
            Nota
            </th>
             </tr>
            <tr>
            <td>
            <p></p>
            </td>
            <td>
            <p>La alegere </p>
            </td>
            <td>
            <p>---</p>
            </td>
            </tr>
            </table>
            </div>
            <div role="tabpanel" class="tab-pane" id="taxe-1">
            <table class="table table-bordered table-condensed table-hover table-white">
            <tr>
            <th>
            Articol
            </th>
            <th>
            Suma
            </th>
            <th>
            Data
            </th>
            </tr>
            <tr>
            <td>
            <p>Taxa pentru admitere</p>
            </td>
            <td>
            <p>30.00 MDL</p>
            </td>
            <td>
            <p>2020-07-15</p>
            </td>
            </tr>
            </table>
            </div>
            <div role="tabpanel" class="tab-pane" id="taxe-2">
            <table class="table table-bordered table-condensed table-hover table-white">
            <tr>
            <th>
            Articol
            </th>
            <th>
            Suma
            </th>
            <th>
            Data
            </th>
            <th>
            Cont de plată
            </th>
            </tr>
            <tr>
            <td colspan="3">
            <center>
            <i>Nu sunt date</i>
            </center>
            </td>
            </tr>
            </table>
            </div>
            </div>
            </div>
            </div>
            <style>
                .view-data h2 {
                    font-size: 22px;
                    margin-bottom: 10px;
                    margin-top: 15px;
                }
            </style></div>
            <script src="/assets/js/bootstrap.min.js"></script>
            <script src="/assets/js/scripts.js"></script>
            <script src="/assets/js/iframeResizer.contentWindow.js"></script>
            <script>
                (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
                })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
                ga('create', 'UA-90571969-1', 'auto');
                ga('send', 'pageview');
            </script>
            <script type="text/javascript">(function(){window['__CF$cv$params']={r:'6ff90ce1fbde38bc',m:'kszDXm4rQXTm7M6zorWE2yX26QanQj_H2jYX4VJahZo-1650574844-0-AT36sMl1wLY1CpVtFIry7gV70+Airk0CIGLBuf4pcuzpBB9xLn0KALM+l+nDdWq+OivbUkP54U9FyttUH+85M/qdtEaNwh77nvFKj9+OFg/qrfWaqMrYqyG7L8Y2caBXh/JbRnQODMKndUIWHcYvFZ1TvI80IY30A4a/iRU5Oh6w',s:[0xa3bd9b06a7,0xed16049fcd],u:'/cdn-cgi/challenge-platform/h/g'}})();</script></body>
            </html>
            """;
}
