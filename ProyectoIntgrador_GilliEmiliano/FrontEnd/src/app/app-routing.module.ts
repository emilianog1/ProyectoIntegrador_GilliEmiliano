import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditExperienciaComponent } from './componentes/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './componentes/experiencia/new-experiencia.component';
import { HomeComponent } from './componentes/home/home.component';
import { LoginComponent } from './componentes/login/login.component';
import { EditProyectoComponent } from './componentes/proyectos/edit-proyecto.component';
import { NewProyectoComponent } from './componentes/proyectos/new-proyecto.component';

const routes: Routes = [
  {path:'',component: HomeComponent}, //cuando sea vacio que routee al componente home
  {path:'login',component: LoginComponent}, //cuando sea login que vaya al login. ejemplo /login
  { path: 'nuevaexp', component: NewExperienciaComponent}, //para ir a la nueva experiencia
  { path: 'editexp/:id', component: EditExperienciaComponent}, //para editar la experiencia y :id es para pasarle un id
  { path: 'nuevopro', component: NewProyectoComponent}, 
  { path: 'editpro/:id', component: EditProyectoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
