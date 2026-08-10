using Microsoft.AspNetCore.Mvc;
using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Services;

namespace Vehiclecfg_group9.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class InvoiceDetailController : ControllerBase
    {
        private readonly InvoiceDetailService _service;

        public InvoiceDetailController(InvoiceDetailService service)
        {
            _service = service;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            return Ok(await _service.GetAllAsync());
        }

        [HttpGet("invoice/{invoiceId}")]
        public async Task<IActionResult> GetInvoiceDetails(long invoiceId)
        {
            return Ok(await _service.GetInvoiceDetails(invoiceId));
        }

        [HttpPost]
        public async Task<IActionResult> Add(InvoiceDetail detail)
        {
            return Ok(await _service.AddAsync(detail));
        }

        [HttpPut]
        public async Task<IActionResult> Update(InvoiceDetail detail)
        {
            return Ok(await _service.UpdateAsync(detail));
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id)
        {
            var result = await _service.DeleteAsync(id);

            if (result == null)
                return NotFound();

            return Ok(result);
        }
    }
}