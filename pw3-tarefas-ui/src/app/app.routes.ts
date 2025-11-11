import { Routes } from '@angular/router';
import { TaskListComponent } from './pages/task-list/task-list.component';
import { TaskFormComponent } from './pages/task-form/task-form.component';

export const routes: Routes = [
  { path: '', redirectTo: 'tarefas', pathMatch: 'full' },
  { path: 'tarefas', component: TaskListComponent },
  { path: 'tarefas/novo', component: TaskFormComponent },
  { path: 'tarefas/id', component: TaskFormComponent },
  { path: 'login', component: TaskFormComponent },
  { path: '**', redirectTo: 'tasks' }
];
