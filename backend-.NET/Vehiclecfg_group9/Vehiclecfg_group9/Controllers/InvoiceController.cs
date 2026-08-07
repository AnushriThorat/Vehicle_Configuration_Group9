using Microsoft.AspNetCore.Mvc;
using Vehiclecfg_group9.DTO;
using Vehiclecfg_group9.Services;

namespace Vehiclecfg_group9.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class InvoiceController : ControllerBase
    {
        private readonly IInvoiceService _invoiceService;

        public InvoiceController(
            IInvoiceService invoiceService)
        {
            _invoiceService = invoiceService;
        }

        // GET: api/Invoice
        [HttpGet]
        public async Task<IActionResult> GetAllInvoices()
        {
            var invoices =
                await _invoiceService.GetAllInvoicesAsync();

            return Ok(invoices);
        }

        // GET: api/Invoice/1
        [HttpGet("{invoiceId}")]
        public async Task<IActionResult> GetInvoiceById(
            long invoiceId)
        {
            var invoice =
                await _invoiceService.GetInvoiceByIdAsync(
                    invoiceId);

            if (invoice == null)
            {
                return NotFound(new
                {
                    message = "Invoice not found."
                });
            }

            return Ok(invoice);
        }

        // POST: api/Invoice
        [HttpPost]
        public async Task<IActionResult> AddInvoice(
            [FromBody] InvoiceCreateDto invoiceDto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var invoice =
                await _invoiceService.AddInvoiceAsync(
                    invoiceDto);

            return CreatedAtAction(
                nameof(GetInvoiceById),
                new
                {
                    invoiceId = invoice.InvId
                },
                invoice
            );
        }

        // PUT: api/Invoice/1
        [HttpPut("{invoiceId}")]
        public async Task<IActionResult> UpdateInvoice(
            long invoiceId,
            [FromBody] InvoiceCreateDto invoiceDto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var invoice =
                await _invoiceService.UpdateInvoiceAsync(
                    invoiceId,
                    invoiceDto);

            if (invoice == null)
            {
                return NotFound(new
                {
                    message = "Invoice not found."
                });
            }

            return Ok(invoice);
        }

        // DELETE: api/Invoice/1
        [HttpDelete("{invoiceId}")]
        public async Task<IActionResult> DeleteInvoice(
            long invoiceId)
        {
            var deleted =
                await _invoiceService.DeleteInvoiceAsync(
                    invoiceId);

            if (!deleted)
            {
                return NotFound(new
                {
                    message = "Invoice not found."
                });
            }

            return Ok(new
            {
                message = "Invoice deleted successfully."
            });
        }
    }
}