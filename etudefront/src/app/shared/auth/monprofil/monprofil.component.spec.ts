import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonprofilComponent } from './monprofil.component';

describe('MonprofilComponent', () => {
  let component: MonprofilComponent;
  let fixture: ComponentFixture<MonprofilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MonprofilComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MonprofilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
