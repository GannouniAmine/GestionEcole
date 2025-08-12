import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionParentComponent } from './gestion-parent.component';

describe('GestionParentComponent', () => {
  let component: GestionParentComponent;
  let fixture: ComponentFixture<GestionParentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestionParentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GestionParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
