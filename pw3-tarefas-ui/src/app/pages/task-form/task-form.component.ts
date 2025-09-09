import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators, AbstractControl } from '@angular/forms';
import { Task } from '../../model/task';
import { HttpClient } from '@angular/common/http';
import { TaskService } from '../../service/task.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css'],
})
export class TaskFormComponent {

  private fb = inject(FormBuilder);
  private http = inject(HttpClient);
  private taskService = inject(TaskService);
  private router = inject(Router);


  id: string | null = null;

  taskForm = this.fb.group({
    id: [null as number | null],
    titulo: ['', Validators.required],
    descricao: [''],
    responsavel: ['', Validators.required],
    dataLimite: ['', Validators.required, ],
    status: ['PENDING', Validators.required],
  });

  onSubmit(): void {
    if (this.taskForm.invalid) return;

    const task: Task = this.taskForm.value as Task;

   this.taskService.createTask(task).subscribe({
      next: () => {
        alert('Tarefa criada com sucesso');
        this.router.navigate(['/tasks']);
      },
      error: (err) => console.error('Erro ao salvar tarefa:', err),
    });
  }

    
      
    }
